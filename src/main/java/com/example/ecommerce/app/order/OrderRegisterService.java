package com.example.ecommerce.app.order;

import com.example.ecommerce.api.order.request.Register;
import com.example.ecommerce.common.exception.BizException;
import com.example.ecommerce.common.exception.CommonException;
import com.example.ecommerce.domain.order.dto.OrderCommand;
import com.example.ecommerce.domain.order.entity.order.Order;
import com.example.ecommerce.domain.order.entity.order_line.OrderLine;
import com.example.ecommerce.domain.order.service.OrderFactory;
import com.example.ecommerce.domain.order.service.OrderMapper;
import com.example.ecommerce.domain.order.service.OrderStore;
import com.example.ecommerce.domain.product.service.ProductReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderRegisterService {

    private final OrderFactory orderFactory;
    private final OrderStore orderStore;
    private final ProductReader productReader;
    private final OrderMapper orderMapper;

    public Long register(Register request) {
        OrderCommand.Register command = orderMapper.commandOf(request);
        Order initOrder = orderFactory.make(command);
        decreaseProductStock(initOrder);
        Order order = orderStore.store(initOrder);
        return order.getId();
    }

    private void decreaseProductStock(Order order) {
        List<OrderLine> orderLineList = order.getOrderLineList();

        Map<Long, Integer> quantityMap = orderLineList.stream()
                .collect(Collectors.toMap(OrderLine::getProductId, OrderLine::getQuantity));

        List<Long> productIdList = orderLineList.stream()
                .map(OrderLine::getProductId)
                .collect(Collectors.toList());

        BizException bizException = new BizException();
        productReader.getProductByIdList(productIdList)
                .stream()
                .forEach(p -> {
                    try {
                        p.decreaseStock(quantityMap.get(p.getId()));
                    } catch (CommonException e) {
                        bizException.addException(e);
                    }
                });
        if (!bizException.getExceptions().isEmpty()) {
            throw bizException;
        }
    }
}

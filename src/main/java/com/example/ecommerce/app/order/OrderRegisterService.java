package com.example.ecommerce.app.order;

import com.example.ecommerce.api.order.request.*;
import com.example.ecommerce.api.order.response.*;
import com.example.ecommerce.common.exception.*;
import com.example.ecommerce.domain.order.command.*;
import com.example.ecommerce.domain.order.entity.order.*;
import com.example.ecommerce.domain.order.entity.order_line.*;
import com.example.ecommerce.domain.order.service.*;
import com.example.ecommerce.domain.product.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;
import java.util.stream.*;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderRegisterService {

    private final OrderMapper orderMapper;
    private final OrderValidator orderValidator;
    private final OrderFactory orderFactory;
    private final OrderStore orderStore;
    private final ProductReader productReader;

    public OrderIdResponse register(RegisterRequest request) {
        RegisterCommand command = orderMapper.commandOf(request);
        orderValidator.validateRegister(command);
        Order initOrder = orderFactory.make(command);
        decreaseProductStock(initOrder);
        Order order = orderStore.store(initOrder);
        return new OrderIdResponse(order.getId());
    }

    private void decreaseProductStock(Order order) {
        List<OrderLine> orderLineList = order.getOrderLineList();

        Map<Long, Integer> quantityMap = orderLineList.stream()
                .collect(Collectors.toMap(ol -> ol.getOrderProduct().getProductId(), OrderLine::getQuantity));

        List<Long> productIdList = orderLineList.stream()
                .map(ol -> ol.getOrderProduct().getProductId())
                .collect(Collectors.toList());

        MultiException multiException = new MultiException();
        productReader.getProductByIdList(productIdList)
                .stream()
                .forEach(p -> {
                    try {
                        p.decreaseStock(quantityMap.get(p.getId()));
                    } catch (CommonException e) {
                        multiException.addException(e);
                    }
                });
        if (!multiException.getExceptions().isEmpty()) {
            throw multiException;
        }
    }
}

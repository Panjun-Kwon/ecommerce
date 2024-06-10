package com.example.ecommerce.app.order;

import com.example.ecommerce.domain.order.dto.OrderCommand;
import com.example.ecommerce.domain.order.entity.order.Order;
import com.example.ecommerce.domain.order.entity.order_line.OrderLine;
import com.example.ecommerce.domain.order.service.OrderFactory;
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

    public Long register(OrderCommand.Register command) {
        Order initOrder = orderFactory.make(command);
        Order order = orderStore.store(initOrder);
        decreaseProductStock(order);
        return order.getId();
    }

    private void decreaseProductStock(Order order) {
        List<OrderLine> orderLineList = order.getOrderLineList();

        Map<Long, Integer> quantityMap = orderLineList.stream()
                .collect(Collectors.toMap(OrderLine::getProductId, OrderLine::getQuantity));

        List<Long> productIdList = orderLineList.stream()
                .map(OrderLine::getProductId)
                .collect(Collectors.toList());

        productReader.getProductAll(productIdList)
                .stream()
                .forEach(p -> p.decreaseStock(quantityMap.get(p.getId())));
    }
}

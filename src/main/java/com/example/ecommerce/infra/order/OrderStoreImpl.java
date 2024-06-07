package com.example.ecommerce.infra.order;

import com.example.ecommerce.domain.order.entity.order.Order;
import com.example.ecommerce.domain.order.service.OrderRepository;
import com.example.ecommerce.domain.order.service.OrderStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderStoreImpl implements OrderStore {

    private final OrderRepository orderRepository;

    @Override
    public Order store(Order initOrder) {
        return orderRepository.save(initOrder);
    }
}

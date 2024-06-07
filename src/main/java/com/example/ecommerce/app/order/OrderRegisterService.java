package com.example.ecommerce.app.order;

import com.example.ecommerce.domain.order.dto.OrderCommand;
import com.example.ecommerce.domain.order.entity.order.Order;
import com.example.ecommerce.domain.order.service.OrderFactory;
import com.example.ecommerce.domain.order.service.OrderStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderRegisterService {

    private final OrderFactory orderFactory;
    private final OrderStore orderStore;

    public Long register(OrderCommand.Register command) {
        Order initOrder = orderFactory.make(command);
        Order order = orderStore.store(initOrder);
        return order.getId();
    }
}

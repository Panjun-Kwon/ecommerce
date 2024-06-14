package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.entity.order.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderReader {
    Order getOrder(Long orderId);

    Order getOrderFetch(Long orderId);

    Page<Order> getOrderAll(Pageable pageable);

    Page<Order> getOrderAllFetch(Pageable pageable);
}

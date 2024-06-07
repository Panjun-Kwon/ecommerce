package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.entity.order.Order;

public interface OrderStore {
    Order store(Order initOrder);
}

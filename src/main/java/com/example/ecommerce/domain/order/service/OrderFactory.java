package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.dto.RegisterCommand;
import com.example.ecommerce.domain.order.entity.order.Order;

public interface OrderFactory {
    Order make(RegisterCommand command);
}

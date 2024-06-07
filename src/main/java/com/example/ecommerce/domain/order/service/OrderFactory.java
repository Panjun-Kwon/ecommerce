package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.dto.OrderCommand;
import com.example.ecommerce.domain.order.entity.order.Order;

public interface OrderFactory {
    Order make(OrderCommand.Register command);
}

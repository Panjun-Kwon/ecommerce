package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.entity.order_line.OrderLine;

import java.util.List;

public interface OrderPriceCalculator {
    void calculate(List<OrderLine> orderLineList);
}

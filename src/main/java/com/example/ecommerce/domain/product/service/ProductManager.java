package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.order.entity.order.*;

public interface ProductManager {
    void increaseProductStock(Order order);

    void decreaseProductStock(Order order);
}

package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.product.dto.RegisterCommand;
import com.example.ecommerce.domain.product.entity.product.Product;

public interface ProductFactory {
    Product make(RegisterCommand command);
}

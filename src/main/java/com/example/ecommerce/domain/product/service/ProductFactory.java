package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.product.dto.ProductCommand;
import com.example.ecommerce.domain.product.entity.product.Product;

public interface ProductFactory {
    Product make(ProductCommand.Register command);
}

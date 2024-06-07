package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.product.entity.product.Product;

public interface ProductStore {
    Product store(Product initPartner);
}

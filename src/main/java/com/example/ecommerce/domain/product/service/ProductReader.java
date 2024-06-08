package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.product.entity.product.Product;

import java.util.List;

public interface ProductReader {
    Product getProduct(Long productId);

    List<Product> getProductAll(List<Long> productIdList);
}

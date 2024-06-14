package com.example.ecommerce.domain.product.service;

@Deprecated
public interface ProductStockAdjuster {
    void decreaseProductStock(Long productId, Integer num);

    void increaseProductStock(Long productId, Integer num);
}

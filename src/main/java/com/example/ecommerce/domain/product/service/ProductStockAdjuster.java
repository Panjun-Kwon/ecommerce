package com.example.ecommerce.domain.product.service;

@Deprecated
public interface ProductStockAdjuster {
    void decreaseProductStock(Long productId, int num);
    void increaseProductStock(Long productId, int num);
}

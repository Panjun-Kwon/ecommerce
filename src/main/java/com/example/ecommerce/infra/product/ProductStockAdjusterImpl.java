package com.example.ecommerce.infra.product;

import com.example.ecommerce.domain.product.service.ProductRepository;
import com.example.ecommerce.domain.product.service.ProductStockAdjuster;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductStockAdjusterImpl implements ProductStockAdjuster {

    private final ProductRepository productRepository;

    @Override
    public void decreaseProductStock(Long productId, int num) {
        productRepository.decreaseStockById(productId, num);
    }

    @Override
    public void increaseProductStock(Long productId, int num) {
        productRepository.increaseStockById(productId, num);
    }
}
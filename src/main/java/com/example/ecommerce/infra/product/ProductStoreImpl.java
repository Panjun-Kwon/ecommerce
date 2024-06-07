package com.example.ecommerce.infra.product;

import com.example.ecommerce.domain.product.entity.product.Product;
import com.example.ecommerce.domain.product.service.ProductRepository;
import com.example.ecommerce.domain.product.service.ProductStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductStoreImpl implements ProductStore {

    private final ProductRepository productRepository;

    @Override
    public Product store(Product initProduct) {
        return productRepository.save(initProduct);
    }
}

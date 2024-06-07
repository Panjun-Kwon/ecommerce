package com.example.ecommerce.infra.product;

import com.example.ecommerce.domain.product.service.ProductRepository;
import com.example.ecommerce.domain.product.service.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductValidatorImpl implements ProductValidator {

    private final ProductRepository productRepository;

    @Override
    public void validateName(String name) {
        if (productRepository.existsByName(name)) {
            throw new RuntimeException("NAME DUPLICATED");
        }
    }
}

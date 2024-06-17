package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.product.dto.RegisterCommand;

public interface ProductValidator {
    void validate(RegisterCommand command);

    void validateName(String name);

    void validateProductId(Long productId);
}

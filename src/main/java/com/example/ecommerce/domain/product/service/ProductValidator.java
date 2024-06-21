package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.product.command.*;

public interface ProductValidator {
    void validateRegister(RegisterCommand command);

    void validateName(String name);

    void validateProductId(Long productId);
}

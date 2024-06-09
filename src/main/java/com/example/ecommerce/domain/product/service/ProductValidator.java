package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.product.dto.ProductCommand;

public interface ProductValidator {
    void validate(ProductCommand.Register command);

    void validateName(String name);

    void validateUnitPrice(int unitPrice);

    void validateStock(int stock);

    void validateProductId(Long productId);
}

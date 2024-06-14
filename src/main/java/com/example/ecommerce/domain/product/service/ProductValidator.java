package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.product.dto.ProductCommand;

public interface ProductValidator {
    void validate(ProductCommand.Register command);

    void validateName(String name);

    void validateUnitPrice(Integer unitPrice);

    void validateStock(Integer stock);

    void validateProductId(Long productId);
}

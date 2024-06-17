package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.dto.OrderCommand;

public interface OrderValidator {
    void validate(OrderCommand.Register command);

    void validatePurchaserId(Long purchaserId);

    void validateOrderLine(OrderCommand.RegisterOrderLine command);

    void validateProductId(Long productId);
}

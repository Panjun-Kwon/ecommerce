package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.dto.OrderLineCommand;
import com.example.ecommerce.domain.order.dto.RegisterCommand;

public interface OrderValidator {
    void validate(RegisterCommand command);

    void validatePurchaserId(Long purchaserId);

    void validateOrderLine(OrderLineCommand command);

    void validateProductId(Long productId);
}

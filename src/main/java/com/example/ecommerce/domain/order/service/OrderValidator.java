package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.command.*;

public interface OrderValidator {
    void validateRegister(RegisterCommand command);

    void validateOrderLine(RegisterCommand.OrderLineCommand command);

    void validatePurchaserId(Long purchaserId);

    void validateProductId(Long productId);
}

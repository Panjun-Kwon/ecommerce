package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.dto.OrderCommand;

import java.util.List;

public interface OrderValidator {
    void validate(OrderCommand.Register command);

    void validatePurchaserId(Long purchaserId);

    void validatePurchaserUsername(String purchaserUsername);

    void validateOrderLineList(List<OrderCommand.RegisterOrderLine> command);

    void validateOrderLine(OrderCommand.RegisterOrderLine command);

    void validateProductId(Long productId);

    void validateName(String name);

    void validateUnitPrice(Integer unitPrice);

    void validateQuantity(Integer quantity);
}

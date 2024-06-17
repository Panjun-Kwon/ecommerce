package com.example.ecommerce.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class OrderLineCommand {
    private OrderProductCommand orderProduct;
    private Integer quantity;
}

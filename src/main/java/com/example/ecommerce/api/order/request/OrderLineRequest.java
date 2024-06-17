package com.example.ecommerce.api.order.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class OrderLineRequest {
    @NotNull
    private OrderProductRequest orderProduct;
    @Min(0)
    private Integer quantity;
}

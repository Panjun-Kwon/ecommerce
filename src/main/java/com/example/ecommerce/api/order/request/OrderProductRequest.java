package com.example.ecommerce.api.order.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class OrderProductRequest {
    @NotNull
    private Long productId;
    @NotNull
    private String name;
    @NotNull
    private Integer price;
}

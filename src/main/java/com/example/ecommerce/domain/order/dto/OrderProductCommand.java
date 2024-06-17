package com.example.ecommerce.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class OrderProductCommand {
    private Long productId;
    private String name;
    private Integer price;
}

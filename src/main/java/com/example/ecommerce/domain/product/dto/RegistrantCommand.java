package com.example.ecommerce.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RegistrantCommand {
    private Long partnerId;
    private String name;
}

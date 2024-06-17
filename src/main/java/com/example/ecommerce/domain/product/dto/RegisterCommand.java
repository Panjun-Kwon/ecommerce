package com.example.ecommerce.domain.product.dto;

import com.example.ecommerce.domain.product.entity.product.Registrant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RegisterCommand {
    private String name;
    private String description;
    private Integer price;
    private Integer stock;
    private Registrant registrant;
}

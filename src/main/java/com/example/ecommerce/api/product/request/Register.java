package com.example.ecommerce.api.product.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class Register {
    @NotNull
    private String name;
    private String description;
    @NotNull
    private Integer price;
    @NotNull
    private Integer stock;
    @NotNull
    private Registrant registrant;
}

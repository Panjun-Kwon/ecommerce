package com.example.ecommerce.api.product.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RegistrantRequest {
    @NotNull
    private Long partnerId;
    @NotNull
    private String name;
}

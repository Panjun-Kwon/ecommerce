package com.example.ecommerce.api.product.request;

import jakarta.validation.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
public class RegisterRequest {
    @NotNull
    private String name;
    private String description;
    @NotNull
    private Integer price;
    @NotNull
    private Integer stock;
    @Valid
    @NotNull
    private RegistrantRequest registrant;

    @Getter
    public static class RegistrantRequest {
        @NotNull
        private Long partnerId;
        @NotNull
        private String name;
    }
}

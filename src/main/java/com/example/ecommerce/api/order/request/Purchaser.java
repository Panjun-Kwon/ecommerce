package com.example.ecommerce.api.order.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class Purchaser {
    @NotNull
    private Long memberId;
    @NotNull
    private String username;
}

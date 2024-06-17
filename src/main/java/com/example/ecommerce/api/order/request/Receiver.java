package com.example.ecommerce.api.order.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class Receiver {
    @NotNull
    private String name;
    @NotNull
    private String phoneNum;
}

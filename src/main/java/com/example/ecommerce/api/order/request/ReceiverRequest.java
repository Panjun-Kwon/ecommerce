package com.example.ecommerce.api.order.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReceiverRequest {
    @NotNull
    private String name;
    @NotNull
    private String phoneNum;
}

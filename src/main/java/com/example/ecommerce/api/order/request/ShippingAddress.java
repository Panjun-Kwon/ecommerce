package com.example.ecommerce.api.order.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ShippingAddress {
    @NotNull
    private String city;
    @NotNull
    private String street;
}

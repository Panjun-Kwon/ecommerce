package com.example.ecommerce.api.order.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
public class ShippingAddressRequest {
    @NotNull
    private String city;
    @NotNull
    private String street;
}

package com.example.ecommerce.api.member.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
public class AddressRequest {
    @NotNull
    private String city;
    @NotNull
    private String street;
}

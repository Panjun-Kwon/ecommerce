package com.example.ecommerce.api.partner.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
public class LoginRequest {
    @NotNull
    private String username;
    @NotNull
    private String password;
}

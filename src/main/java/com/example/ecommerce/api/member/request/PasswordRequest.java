package com.example.ecommerce.api.member.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
public class PasswordRequest {
    @NotNull
    private String password;
}

package com.example.ecommerce.api.member.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
public class EmailRequest {
    @NotNull
    @Email
    private String email;
}

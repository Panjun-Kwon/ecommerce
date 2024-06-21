package com.example.ecommerce.api.member.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
public class PhoneNumRequest {
    @NotNull
    private String phoneNum;
}

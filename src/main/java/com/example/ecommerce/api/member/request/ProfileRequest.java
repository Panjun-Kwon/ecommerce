package com.example.ecommerce.api.member.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
public class ProfileRequest {
    @Email
    private String email;
    private String phoneNum;
}

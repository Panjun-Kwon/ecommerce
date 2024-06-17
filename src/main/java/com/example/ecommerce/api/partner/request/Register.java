package com.example.ecommerce.api.partner.request;

import com.example.ecommerce.api.member.request.AddressRequest;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class Register {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @Email
    private String email;
    private String phoneNum;
    private AddressRequest addressRequest;
}

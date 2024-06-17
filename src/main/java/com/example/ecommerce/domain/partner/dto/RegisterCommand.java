package com.example.ecommerce.domain.partner.dto;

import com.example.ecommerce.domain.partner.entity.partner.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RegisterCommand {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNum;
    private Address address;
}

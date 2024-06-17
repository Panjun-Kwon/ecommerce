package com.example.ecommerce.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SignUpCommand {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phoneNum;
    private AddressCommand address;
}

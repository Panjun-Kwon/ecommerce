package com.example.ecommerce.domain.member.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class ProfileCommand {
    private String name;
    private String email;
    private String phoneNum;
}

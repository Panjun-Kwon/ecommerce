package com.example.ecommerce.domain.member.dto;

import com.example.ecommerce.domain.member.entity.member.Address;
import lombok.*;

public class MemberCommand {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SignUp {
        private String username;
        private String password;
        private String name;
        private String email;
        private String phoneNum;
        private Address address;
    }
}

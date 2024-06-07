package com.example.ecommerce.domain.member.dto;

import lombok.*;

public class MemberCommand {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class SignUp {
        private String username;
    }
}

package com.example.ecommerce.api.member.response;

import lombok.*;

@Getter
@AllArgsConstructor
public class MemberProfileResponse {

    private Long memberId;
    private ProfileInfo profile;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ProfileInfo {
        private String name;
        private String email;
        private String phoneNum;
    }
}

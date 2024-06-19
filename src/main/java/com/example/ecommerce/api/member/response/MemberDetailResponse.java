package com.example.ecommerce.api.member.response;

import lombok.*;

@Getter
@AllArgsConstructor
public class MemberDetailResponse {

    private MemberInfo member;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberInfo {
        private Long id;
        private String username;
        private String name;
        private String email;
        private String phoneNum;
        private AddressInfo address;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class AddressInfo {
        private String city;
        private String street;
    }
}

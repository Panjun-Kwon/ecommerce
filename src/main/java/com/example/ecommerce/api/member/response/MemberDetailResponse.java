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
        private MemberProfileResponse profile;
        private AddressResponse.AddressInfo address;
    }
}

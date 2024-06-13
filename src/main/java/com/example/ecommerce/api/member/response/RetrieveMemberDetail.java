package com.example.ecommerce.api.member.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RetrieveMemberDetail {

    private MemberInfo member;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberInfo {
        private Long id;
        private String username;
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

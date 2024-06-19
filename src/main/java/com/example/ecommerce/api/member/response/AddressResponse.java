package com.example.ecommerce.api.member.response;

import lombok.*;

@Getter
@AllArgsConstructor
public class AddressResponse {

    private AddressInfo address;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class AddressInfo {
        private String city;
        private String street;
    }
}

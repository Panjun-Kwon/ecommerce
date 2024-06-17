package com.example.ecommerce.domain.partner.dto;

import com.example.ecommerce.domain.partner.entity.partner.Address;
import lombok.*;

public class PartnerCommand {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Register {
        private String username;
        private String password;
        private String name;
        private String email;
        private String phoneNum;
        private Address address;
    }
}

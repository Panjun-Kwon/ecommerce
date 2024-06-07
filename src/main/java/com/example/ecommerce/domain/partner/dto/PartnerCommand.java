package com.example.ecommerce.domain.partner.dto;

import lombok.*;

public class PartnerCommand {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Register {
        private String name;
    }
}

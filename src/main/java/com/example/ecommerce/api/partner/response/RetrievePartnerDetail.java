package com.example.ecommerce.api.partner.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RetrievePartnerDetail {

    private final PartnerInfo partner;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PartnerInfo {
        private Long id;
        private String name;
    }


}

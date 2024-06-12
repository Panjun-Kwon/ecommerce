package com.example.ecommerce.domain.partner.dto;

import com.example.ecommerce.domain.partner.entity.partner.Partner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PartnerInfo {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PartnerDetail {

        private Long id;
        private String name;

        public static PartnerInfo.PartnerDetail of(Partner partner) {
            return PartnerInfo.PartnerDetail.builder()
                    .id(partner.getId())
                    .name(partner.getName())
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PartnerList {

        private Long id;
        private String name;

        public static PartnerInfo.PartnerList of(Partner partner) {
            return PartnerInfo.PartnerList.builder()
                    .id(partner.getId())
                    .name(partner.getName())
                    .build();
        }
    }
}

package com.example.ecommerce.api.partner.dto;

import com.example.ecommerce.domain.partner.dto.PartnerInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class PartnerResponse {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PartnerDetail {
        private PartnerInfo.PartnerDetail partner;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PartnerList {
        private List<PartnerInfo.PartnerList> partnerList;
        private Integer currentElements;
        private Integer totalPages;
        private Long totalElements;
    }
}

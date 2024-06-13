package com.example.ecommerce.api.partner.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RetrievePartnerList {

    private List<PartnerInfo> partnerList;
    private PageInfo page;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PartnerInfo {
        private Long id;
        private String name;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PageInfo {
        private Integer currentElements;
        private Integer totalPages;
        private Long totalElements;
    }
}

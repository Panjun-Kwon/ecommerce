package com.example.ecommerce.api.product.dto;

import com.example.ecommerce.domain.partner.dto.PartnerInfo;
import com.example.ecommerce.domain.product.dto.ProductInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class ProductResponse {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ProductDetail {
        private ProductInfo.ProductDetail product;
        private PartnerInfo.PartnerSimple partner;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ProductSimple {
        List<Info> productList;
        private Integer currentElements;
        private Integer totalPages;
        private Long totalElements;

        @Getter
        @Builder
        @AllArgsConstructor
        public static class Info {
            private ProductInfo.ProductSimple product;
            private PartnerInfo.PartnerSimple partner;
        }
    }
}

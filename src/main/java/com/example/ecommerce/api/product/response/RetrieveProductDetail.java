package com.example.ecommerce.api.product.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RetrieveProductDetail {

    private ProductInfo product;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ProductInfo {
        private Long id;
        private String name;
        private int price;
        private int stock;
        private PartnerInfo partner;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PartnerInfo {
        private Long id;
        private String name;
    }
}

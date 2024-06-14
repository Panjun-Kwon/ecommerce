package com.example.ecommerce.domain.product.dto;

import lombok.*;

public class ProductCommand {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Register {
        private String name;
        private Integer unitPrice;
        private Integer stock;
        private Long partnerId;
    }
}

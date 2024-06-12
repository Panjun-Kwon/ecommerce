package com.example.ecommerce.domain.product.dto;

import com.example.ecommerce.domain.product.entity.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ProductInfo {

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ProductDetail {

        private Long id;
        private String name;
        private int unitPrice;
        private int stock;

        public static ProductInfo.ProductDetail of(Product product) {
            return ProductDetail.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .unitPrice(product.getUnitPrice())
                    .stock(product.getStock())
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ProductSimple {

        private Long id;
        private String name;
        private int unitPrice;

        public static ProductSimple of(Product product) {
            return ProductSimple.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .unitPrice(product.getUnitPrice())
                    .build();
        }
    }
}

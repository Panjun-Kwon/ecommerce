package com.example.ecommerce.api.product.dto;

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
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ProductList {
        List<ProductInfo.ProductList> productList;
        private Integer currentElements;
        private Integer totalPages;
        private Long totalElements;
    }
}

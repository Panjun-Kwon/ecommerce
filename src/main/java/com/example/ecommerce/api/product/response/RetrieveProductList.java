package com.example.ecommerce.api.product.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class RetrieveProductList {

    private List<ProductInfo> productList;
    private PageInfo page;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ProductInfo {
        private Long id;
        private String name;
        private int price;
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

package com.example.ecommerce.domain.product.dto;

import com.example.ecommerce.domain.product.entity.product.Registrant;
import lombok.*;

public class ProductCommand {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Register {
        private String name;
        private String description;
        private Integer price;
        private Integer stock;
        private Registrant registrant;
    }
}

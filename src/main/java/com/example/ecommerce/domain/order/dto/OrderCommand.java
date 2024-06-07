package com.example.ecommerce.domain.order.dto;

import lombok.*;

import java.util.List;

public class OrderCommand {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Register {
        private Long purchaserId;
        private String purchaserUsername;
        private String receiverAddressCity;
        private String receiverAddressStreet;
        private List<RegisterOrderLine> orderLineList;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RegisterOrderLine {
        private Long productId;
        private String name;
        private int unitPrice;
        private int quantity;
    }
}

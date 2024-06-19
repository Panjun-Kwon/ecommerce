package com.example.ecommerce.api.order.response;

import lombok.*;

import java.time.*;
import java.util.*;

@Getter
@AllArgsConstructor
public class OrderDetailResponse {

    private OrderInfo order;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class OrderInfo {
        private Long id;
        private List<OrderLineInfo> orderLineList;
        private int orderPrice;
        private LocalDateTime orderTime;
        private PurchaserInfo purchaser;
        private ReceiverInfo receiver;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class PurchaserInfo {
        private Long memberId;
        private String username;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ReceiverInfo {
        private String name;
        private String phoneNum;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class ShippingAddressInfo {
        private String city;
        private String street;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class OrderLineInfo {
        private Long id;
        private OrderProductInfo orderProduct;
        private int quantity;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class OrderProductInfo {
        private Long productId;
        private String name;
        private Integer price;
    }
}

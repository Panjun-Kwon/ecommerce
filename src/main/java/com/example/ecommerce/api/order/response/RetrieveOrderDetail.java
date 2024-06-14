package com.example.ecommerce.api.order.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class RetrieveOrderDetail {

    private OrderInfo order;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class OrderInfo {
        private Long id;
        private PurchaserInfo purchaser;
        private ReceiverInfo receiver;
        private List<OrderLineInfo> orderLineList;
        private int orderPrice;
        private LocalDateTime orderTime;
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
        private AddressInfo address;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class AddressInfo {
        private String city;
        private String street;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class OrderLineInfo {
        private Long id;
        private String name;
        private int unitPrice;
        private int quantity;
    }
}

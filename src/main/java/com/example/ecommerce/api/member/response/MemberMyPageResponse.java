package com.example.ecommerce.api.member.response;

import lombok.*;

import java.time.*;
import java.util.*;

@Getter
@AllArgsConstructor
public class MemberMyPageResponse {

    private MemberInfo member;
    private List<OrderInfo> orderList;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberInfo {
        private Long id;
        private String username;
        private String name;
        private String email;
        private String phoneNum;
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
    public static class OrderInfo {
        private Long id;
        private OrderLineInfo orderLine;
        private Integer orderPrice;
        private LocalDateTime orderTime;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class OrderLineInfo {
        private Long id;
        private OrderProductInfo orderProduct;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class OrderProductInfo {
        private Long productId;
        private String name;
    }
}

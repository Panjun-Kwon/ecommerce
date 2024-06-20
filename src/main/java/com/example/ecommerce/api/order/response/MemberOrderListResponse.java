package com.example.ecommerce.api.order.response;

import lombok.*;

import java.time.*;
import java.util.*;

@Getter
@AllArgsConstructor
public class MemberOrderListResponse {

    private List<OrderInfo> orderList;

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
        private Long id;
        private String name;
    }
}

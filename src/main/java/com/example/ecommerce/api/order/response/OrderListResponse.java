package com.example.ecommerce.api.order.response;

import lombok.*;

import java.time.*;
import java.util.*;

@Getter
@AllArgsConstructor
public class OrderListResponse {

    private List<OrderInfo> orderList;
    private PageInfo page;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class OrderInfo {
        private Long id;
        private OrderLineInfo orderLine;
        private int orderPrice;
        private LocalDateTime orderTime;
        private PurchaserInfo purchaser;
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
    public static class PageInfo {
        private Integer currentElements;
        private Integer totalPages;
        private Long totalElements;
    }

}

package com.example.ecommerce.api.order.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class RetrieveOrderList {

    private List<OrderInfo> orderList;
    private PageInfo page;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class OrderInfo {
        private Long id;
        private PurchaserInfo purchaser;
        private OrderLineInfo orderLine;
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
    public static class OrderLineInfo {
        private Long id;
        private String name;
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

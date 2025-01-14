package com.example.ecommerce.api.member.response;

import com.example.ecommerce.api.order.response.*;
import lombok.*;

import java.time.*;
import java.util.*;

@Getter
@AllArgsConstructor
public class MemberPageResponse {

    private MemberInfo member;
    private List<MemberOrderListResponse.OrderInfo> orderList;

    @Getter
    @Builder
    @AllArgsConstructor
    public static class MemberInfo {
        private Long id;
        private String username;
        private MemberProfileResponse.ProfileInfo profile;
        private AddressResponse.AddressInfo address;
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
        private Long id;
        private String name;
    }
}

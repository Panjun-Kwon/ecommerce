package com.example.ecommerce.api.order.request;

import jakarta.validation.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.*;

@Getter
public class RegisterRequest {
    @Valid
    @NotNull
    private List<OrderLineRequest> orderLineList;
    @NotNull
    private Integer orderPrice;
    @Valid
    @NotNull
    private PurchaserRequest purchaser;
    @Valid
    @NotNull
    private ReceiverRequest receiver;
    @Valid
    @NotNull
    private ShippingAddressRequest shippingAddress;

    @Getter
    public static class OrderLineRequest {
        @Valid
        @NotNull
        private OrderProductRequest orderProduct;
        @Min(0)
        private Integer quantity;
    }

    @Getter
    public static class OrderProductRequest {
        @NotNull
        private Long productId;
        @NotNull
        private String name;
        @NotNull
        private Integer price;
    }

    @Getter
    public static class PurchaserRequest {
        @NotNull
        private Long memberId;
        @NotNull
        private String username;
    }

    @Getter
    public static class ReceiverRequest {
        @NotNull
        private String name;
        @NotNull
        private String phoneNum;
    }

    @Getter
    public static class ShippingAddressRequest {
        @NotNull
        private String city;
        @NotNull
        private String street;
    }
}
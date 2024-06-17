package com.example.ecommerce.api.order.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class RegisterRequest {
    @NotNull
    private List<OrderLineRequest> orderLineList;
    @NotNull
    private Integer orderPrice;
    @NotNull
    private PurchaserRequest purchaser;
    @NotNull
    private ReceiverRequest receiver;
    @NotNull
    private ShippingAddressRequest shippingAddress;
}
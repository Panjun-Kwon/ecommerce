package com.example.ecommerce.api.order.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.List;

@Getter
public class Register {
    @NotNull
    private List<OrderLine> orderLineList;
    @NotNull
    private Integer orderPrice;
    @NotNull
    private Purchaser purchaser;
    @NotNull
    private Receiver receiver;
    @NotNull
    private ShippingAddress shippingAddress;
}
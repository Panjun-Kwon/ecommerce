package com.example.ecommerce.domain.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class RegisterCommand {
    private List<OrderLineCommand> orderLineList;
    private PurchaserCommand purchaser;
    private ReceiverCommand receiver;
    private ShippingAddressCommand shippingAddress;
}

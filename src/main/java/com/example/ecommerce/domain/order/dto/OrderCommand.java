package com.example.ecommerce.domain.order.dto;

import com.example.ecommerce.domain.order.entity.order.Purchaser;
import com.example.ecommerce.domain.order.entity.order.Receiver;
import com.example.ecommerce.domain.order.entity.order.ShippingAddress;
import com.example.ecommerce.domain.order.entity.order_line.OrderProduct;
import lombok.*;

import java.util.List;

public class OrderCommand {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Register {
        private List<RegisterOrderLine> orderLineList;
        private Purchaser purchaser;
        private Receiver receiver;
        private ShippingAddress shippingAddress;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class RegisterOrderLine {
        private OrderProduct orderProduct;
        private Integer quantity;
    }
}

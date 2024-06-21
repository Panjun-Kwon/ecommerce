package com.example.ecommerce.infra.order;

import com.example.ecommerce.domain.order.command.*;
import com.example.ecommerce.domain.order.entity.order.*;
import com.example.ecommerce.domain.order.entity.order_line.*;
import com.example.ecommerce.domain.order.service.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
@RequiredArgsConstructor
public class OrderFactoryImpl implements OrderFactory {
    @Override
    public Order make(RegisterCommand command) {

        List<OrderLine> orderLineList = command.getOrderLineList().stream()
                .map(ol -> OrderLine.builder()
                        .orderProduct(OrderProduct.builder()
                                .productId(ol.getOrderProduct().getProductId())
                                .name(ol.getOrderProduct().getName())
                                .price(ol.getOrderProduct().getPrice())
                                .build())
                        .quantity(ol.getQuantity())
                        .build())
                .collect(Collectors.toList());

        Purchaser purchaser = Purchaser.builder()
                .memberId(command.getPurchaser().getMemberId())
                .username(command.getPurchaser().getUsername())
                .build();

        Receiver receiver = Receiver.builder()
                .name(command.getReceiver().getName())
                .phoneNum(command.getReceiver().getPhoneNum())
                .build();

        ShippingAddress shippingAddress = ShippingAddress.builder()
                .city(command.getShippingAddress().getCity())
                .street(command.getShippingAddress().getStreet())
                .build();

        Order order = Order.builder()
                .orderLineList(orderLineList)
                .purchaser(purchaser)
                .receiver(receiver)
                .shippingAddress(shippingAddress)
                .build();

        order.calculateOrderPrice();

        return order;
    }
}

package com.example.ecommerce.infra.order;

import com.example.ecommerce.domain.order.dto.OrderCommand;
import com.example.ecommerce.domain.order.entity.order.Order;
import com.example.ecommerce.domain.order.entity.order.Purchaser;
import com.example.ecommerce.domain.order.entity.order.Receiver;
import com.example.ecommerce.domain.order.entity.order.ShippingAddress;
import com.example.ecommerce.domain.order.entity.order_line.OrderLine;
import com.example.ecommerce.domain.order.entity.order_line.OrderProduct;
import com.example.ecommerce.domain.order.service.OrderFactory;
import com.example.ecommerce.domain.order.service.OrderValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderFactoryImpl implements OrderFactory {

    private final OrderValidator orderValidator;

    @Override
    public Order make(OrderCommand.Register command) {

        orderValidator.validate(command);

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

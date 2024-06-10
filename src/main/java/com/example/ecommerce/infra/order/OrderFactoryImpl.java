package com.example.ecommerce.infra.order;

import com.example.ecommerce.domain.order.dto.OrderCommand;
import com.example.ecommerce.domain.order.entity.order.Address;
import com.example.ecommerce.domain.order.entity.order.Order;
import com.example.ecommerce.domain.order.entity.order.Purchaser;
import com.example.ecommerce.domain.order.entity.order.Receiver;
import com.example.ecommerce.domain.order.entity.order_line.OrderLine;
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

        Purchaser purchaser = Purchaser.builder()
                .memberId(command.getPurchaserId())
                .username(command.getPurchaserUsername())
                .build();

        Address receiverAddress = Address.builder()
                .city(command.getReceiverAddressCity())
                .street(command.getReceiverAddressStreet())
                .build();

        Receiver receiver = Receiver.builder()
                .address(receiverAddress)
                .build();

        List<OrderLine> orderLineList = command.getOrderLineList().stream()
                .map((ol) -> OrderLine.builder()
                        .productId(ol.getProductId())
                        .name(ol.getName())
                        .unitPrice(ol.getUnitPrice())
                        .quantity(ol.getQuantity())
                        .build())
                .collect(Collectors.toList());

        Order order = Order.builder()
                .purchaser(purchaser)
                .receiver(receiver)
                .orderLineList(orderLineList)
                .build();

        order.calculateOrderPrice();

        return order;
    }
}

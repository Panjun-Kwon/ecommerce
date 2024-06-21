package com.example.ecommerce.domain.order.command;

import com.example.ecommerce.api.order.request.*;
import com.example.ecommerce.domain.order.entity.order.*;
import com.example.ecommerce.domain.order.entity.order_line.*;
import lombok.*;

import java.util.*;
import java.util.stream.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCommand {

    private List<OrderLineCommand> orderLineList;
    private PurchaserCommand purchaser;
    private ReceiverCommand receiver;
    private ShippingAddressCommand shippingAddress;

    public static RegisterCommand of(RegisterRequest request) {
        return RegisterCommand.builder()
                .orderLineList(request.getOrderLineList().stream()
                        .map(olr -> OrderLineCommand.of(olr))
                        .collect(Collectors.toList()))
                .purchaser(PurchaserCommand.of(request.getPurchaser()))
                .receiver(ReceiverCommand.of(request.getReceiver()))
                .shippingAddress(ShippingAddressCommand.of(request.getShippingAddress()))
                .build();
    }

    public static Order toOrder(RegisterCommand command) {
        return Order.builder()
                .orderLineList(command.orderLineList.stream()
                        .map(olc -> OrderLineCommand.toOrderLine(olc))
                        .collect(Collectors.toList()))
                .purchaser(PurchaserCommand.toPurchaser(command.getPurchaser()))
                .receiver(ReceiverCommand.toReceiver(command.getReceiver()))
                .shippingAddress(ShippingAddressCommand.toShippingAddress(command.getShippingAddress()))
                .build();
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderLineCommand {
        private OrderProductCommand orderProduct;
        private Integer quantity;

        public static OrderLineCommand of(RegisterRequest.OrderLineRequest request) {
            if (request == null) new OrderLineCommand();
            return OrderLineCommand.builder()
                    .orderProduct(OrderProductCommand.of(request.getOrderProduct()))
                    .quantity(request.getQuantity())
                    .build();
        }

        public static OrderLine toOrderLine(OrderLineCommand command) {
            if (command == null) new OrderLine();
            return OrderLine.builder()
                    .orderProduct(OrderProductCommand.toOrderProduct(command.orderProduct))
                    .quantity(command.quantity)
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OrderProductCommand {
        private Long productId;
        private String name;
        private Integer price;

        public static OrderProductCommand of(RegisterRequest.OrderProductRequest request) {
            if (request == null) new OrderProductCommand();
            return OrderProductCommand.builder()
                    .productId(request.getProductId())
                    .name(request.getName())
                    .price(request.getPrice())
                    .build();
        }

        public static OrderProduct toOrderProduct(OrderProductCommand command) {
            if (command == null) new OrderProduct();
            return OrderProduct.builder()
                    .productId(command.productId)
                    .name(command.name)
                    .price(command.price)
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PurchaserCommand {
        private Long memberId;
        private String username;

        public static PurchaserCommand of(RegisterRequest.PurchaserRequest request) {
            if (request == null) new PurchaserCommand();
            return PurchaserCommand.builder()
                    .memberId(request.getMemberId())
                    .username(request.getUsername())
                    .build();
        }

        public static Purchaser toPurchaser(PurchaserCommand command) {
            if (command == null) new Purchaser();
            return Purchaser.builder()
                    .memberId(command.memberId)
                    .username(command.username)
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ReceiverCommand {
        private String name;
        private String phoneNum;

        public static ReceiverCommand of(RegisterRequest.ReceiverRequest request) {
            if (request == null) new ReceiverCommand();
            return ReceiverCommand.builder()
                    .name(request.getName())
                    .phoneNum(request.getPhoneNum())
                    .build();
        }

        public static Receiver toReceiver(ReceiverCommand command) {
            if (command == null) new Receiver();
            return Receiver.builder()
                    .name(command.name)
                    .phoneNum(command.phoneNum)
                    .build();
        }
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ShippingAddressCommand {
        private String city;
        private String street;

        public static ShippingAddressCommand of(RegisterRequest.ShippingAddressRequest request) {
            if (request == null) new ShippingAddressCommand();
            return ShippingAddressCommand.builder()
                    .city(request.getCity())
                    .street(request.getStreet())
                    .build();
        }

        public static ShippingAddress toShippingAddress(ShippingAddressCommand command) {
            if (command == null) new ShippingAddress();
            return ShippingAddress.builder()
                    .city(command.city)
                    .street(command.street)
                    .build();
        }
    }
}

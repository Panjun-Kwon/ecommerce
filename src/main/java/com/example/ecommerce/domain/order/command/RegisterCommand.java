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
                        .map(ol -> OrderLineCommand.of(ol))
                        .collect(Collectors.toList()))
                .purchaser(PurchaserCommand.of(request.getPurchaser()))
                .receiver(ReceiverCommand.of(request.getReceiver()))
                .shippingAddress(ShippingAddressCommand.of(request.getShippingAddress()))
                .build();
    }

    public Order toOrder() {
        return Order.builder()
                .orderLineList(this.orderLineList.stream()
                        .map(ol -> ol.toOrderLine())
                        .collect(Collectors.toList()))
                .purchaser(this.getPurchaser().toPurchaser())
                .receiver(this.getReceiver().toReceiver())
                .shippingAddress(this.getShippingAddress().toShippingAddress())
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
            return new OrderLineCommand(OrderProductCommand.of(request.getOrderProduct()), request.getQuantity());
        }

        public OrderLine toOrderLine() {
            if (this == null) new OrderLine();
            return new OrderLine(this.orderProduct.toOrderProduct(), this.quantity);
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
            return new OrderProductCommand(request.getProductId(), request.getName(), request.getPrice());
        }

        public OrderProduct toOrderProduct() {
            if (this == null) new OrderProduct();
            return new OrderProduct(this.productId, this.name, this.price);
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
            return new PurchaserCommand(request.getMemberId(), request.getUsername());
        }

        public Purchaser toPurchaser() {
            if (this == null) new Purchaser();
            return new Purchaser(this.memberId, this.username);
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
            return new ReceiverCommand(request.getName(), request.getPhoneNum());
        }

        public Receiver toReceiver() {
            if (this == null) new Receiver();
            return new Receiver(this.name, this.phoneNum);
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
            return new ShippingAddressCommand(request.getCity(), request.getStreet());
        }

        public ShippingAddress toShippingAddress() {
            if (this == null) new ShippingAddress();
            return new ShippingAddress(this.city, this.street);
        }
    }
}

package com.example.ecommerce.infra.order;

import com.example.ecommerce.api.order.request.RegisterRequest;
import com.example.ecommerce.api.order.response.RetrieveOrderDetail;
import com.example.ecommerce.api.order.response.RetrieveOrderList;
import com.example.ecommerce.domain.order.dto.*;
import com.example.ecommerce.domain.order.entity.order.Order;
import com.example.ecommerce.domain.order.service.OrderMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public RetrieveOrderDetail.OrderInfo retrieveDetailOf(Order order) {

        RetrieveOrderDetail.PurchaserInfo purchaserInfo = RetrieveOrderDetail.PurchaserInfo.builder()
                .memberId(order.getPurchaser().getMemberId())
                .username(order.getPurchaser().getUsername())
                .build();

        RetrieveOrderDetail.AddressInfo addressInfo = RetrieveOrderDetail.AddressInfo.builder()
                .city(order.getShippingAddress().getCity())
                .street(order.getShippingAddress().getStreet())
                .build();

        RetrieveOrderDetail.ReceiverInfo receiverInfo = RetrieveOrderDetail.ReceiverInfo.builder()
                .address(addressInfo)
                .build();

        List<RetrieveOrderDetail.OrderLineInfo> orderLineInfoList = order.getOrderLineList().stream()
                .map(ol -> RetrieveOrderDetail.OrderLineInfo.builder()
                        .id(ol.getId())
                        .name(ol.getOrderProduct().getName())
                        .price(ol.getOrderProduct().getPrice())
                        .quantity(ol.getQuantity())
                        .build())
                .collect(Collectors.toList());

        RetrieveOrderDetail.OrderInfo orderInfo = RetrieveOrderDetail.OrderInfo.builder()
                .id(order.getId())
                .purchaser(purchaserInfo)
                .receiver(receiverInfo)
                .orderLineList(orderLineInfoList)
                .orderPrice(order.getOrderPrice())
                .orderTime(order.getOrderTime())
                .build();

        return orderInfo;
    }

    @Override
    public List<RetrieveOrderList.OrderInfo> retrieveListOf(List<Order> orderList) {

        List<RetrieveOrderList.OrderInfo> orderInfo = orderList.stream()
                .map(ol -> RetrieveOrderList.OrderInfo.builder()
                        .id(ol.getId())
                        .purchaser(RetrieveOrderList.PurchaserInfo.builder()
                                .memberId(ol.getPurchaser().getMemberId())
                                .username(ol.getPurchaser().getUsername())
                                .build())
                        .orderLine(RetrieveOrderList.OrderLineInfo.builder()
                                .id(ol.getOrderLineList().get(0).getId())
                                .name(ol.getOrderLineList().get(0).getOrderProduct().getName())
                                .build())
                        .orderPrice(ol.getOrderPrice())
                        .orderTime(ol.getOrderTime())
                        .build())
                .collect(Collectors.toList());

        return orderInfo;
    }

    @Override
    public RegisterCommand commandOf(RegisterRequest request) {

        List<OrderLineCommand> orderLineList = request.getOrderLineList().stream()
                .map(ol -> OrderLineCommand.builder()
                        .orderProduct(OrderProductCommand.builder()
                                .productId(ol.getOrderProduct().getProductId())
                                .name(ol.getOrderProduct().getName())
                                .price(ol.getOrderProduct().getPrice())
                                .build())
                        .quantity(ol.getQuantity())
                        .build())
                .collect(Collectors.toList());

        PurchaserCommand purchaser = PurchaserCommand.builder()
                .memberId(request.getPurchaser().getMemberId())
                .username(request.getPurchaser().getUsername())
                .build();

        ReceiverCommand receiver = ReceiverCommand.builder()
                .name(request.getReceiver().getName())
                .phoneNum(request.getReceiver().getPhoneNum())
                .build();

        ShippingAddressCommand shippingAddress = ShippingAddressCommand.builder()
                .city(request.getShippingAddress().getCity())
                .street(request.getShippingAddress().getStreet())
                .build();

        RegisterCommand command = RegisterCommand.builder()
                .orderLineList(orderLineList)
                .purchaser(purchaser)
                .receiver(receiver)
                .shippingAddress(shippingAddress)
                .build();

        return command;
    }
}

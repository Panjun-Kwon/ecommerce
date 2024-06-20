package com.example.ecommerce.infra.order;

import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.api.order.request.*;
import com.example.ecommerce.api.order.response.*;
import com.example.ecommerce.domain.order.dto.*;
import com.example.ecommerce.domain.order.entity.order.*;
import com.example.ecommerce.domain.order.service.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Component
public class OrderMapperImpl implements OrderMapper {
    @Override
    public OrderDetailResponse.OrderInfo retrieveDetailOf(Order order) {

        OrderDetailResponse.PurchaserInfo purchaserInfo = OrderDetailResponse.PurchaserInfo.builder()
                .memberId(order.getPurchaser().getMemberId())
                .username(order.getPurchaser().getUsername())
                .build();

        OrderDetailResponse.ShippingAddressInfo shippingAddressInfo = OrderDetailResponse.ShippingAddressInfo.builder()
                .city(order.getShippingAddress().getCity())
                .street(order.getShippingAddress().getStreet())
                .build();

        OrderDetailResponse.ReceiverInfo receiverInfo = OrderDetailResponse.ReceiverInfo.builder()
                .name(order.getReceiver().getName())
                .phoneNum(order.getReceiver().getPhoneNum())
                .build();

        List<OrderDetailResponse.OrderLineInfo> orderLineInfoList = order.getOrderLineList().stream()
                .map(ol -> OrderDetailResponse.OrderLineInfo.builder()
                        .id(ol.getId())
                        .orderProduct(OrderDetailResponse.OrderProductInfo.builder()
                                .productId(ol.getOrderProduct().getProductId())
                                .name(ol.getOrderProduct().getName())
                                .price(ol.getOrderProduct().getPrice())
                                .build())
                        .quantity(ol.getQuantity())
                        .build())
                .collect(Collectors.toList());

        OrderDetailResponse.OrderInfo orderInfo = OrderDetailResponse.OrderInfo.builder()
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
    public List<OrderListResponse.OrderInfo> retrieveListOf(List<Order> orderList) {

        List<OrderListResponse.OrderInfo> orderInfo = orderList.stream()
                .map(ol -> OrderListResponse.OrderInfo.builder()
                        .id(ol.getId())
                        .purchaser(OrderListResponse.PurchaserInfo.builder()
                                .memberId(ol.getPurchaser().getMemberId())
                                .username(ol.getPurchaser().getUsername())
                                .build())
                        .orderLine(OrderListResponse.OrderLineInfo.builder()
                                .id(ol.getOrderLineList().get(0).getId())
                                .orderProduct(OrderListResponse.OrderProductInfo.builder()
                                        .productId(ol.getOrderLineList().get(0).getOrderProduct().getProductId())
                                        .name(ol.getOrderLineList().get(0).getOrderProduct().getName())
                                        .build())
                                .build())
                        .orderPrice(ol.getOrderPrice())
                        .orderTime(ol.getOrderTime())
                        .build())
                .collect(Collectors.toList());

        return orderInfo;
    }

    @Override
    public List<MemberPageResponse.OrderInfo> retrieveMyPageListOf(List<Order> orderList) {

        List<MemberPageResponse.OrderInfo> orderInfo = orderList.stream()
                .map(ol -> MemberPageResponse.OrderInfo.builder()
                        .id(ol.getId())
                        .orderLine(MemberPageResponse.OrderLineInfo.builder()
                                .id(ol.getOrderLineList().get(0).getId())
                                .orderProduct(MemberPageResponse.OrderProductInfo.builder()
                                        .id(ol.getOrderLineList().get(0).getOrderProduct().getProductId())
                                        .name(ol.getOrderLineList().get(0).getOrderProduct().getName())
                                        .build())
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

    @Override
    public List<MemberOrderListResponse.OrderInfo> retrieveMemberOrderListOf(List<Order> memberOrderList) {

        List<MemberOrderListResponse.OrderInfo> orderInfo = memberOrderList.stream()
                .map(ol -> MemberOrderListResponse.OrderInfo.builder()
                        .id(ol.getId())
                        .orderLine(MemberOrderListResponse.OrderLineInfo.builder()
                                .id(ol.getOrderLineList().get(0).getId())
                                .orderProduct(MemberOrderListResponse.OrderProductInfo.builder()
                                        .id(ol.getOrderLineList().get(0).getOrderProduct().getProductId())
                                        .name(ol.getOrderLineList().get(0).getOrderProduct().getName())
                                        .build())
                                .build())
                        .orderPrice(ol.getOrderPrice())
                        .orderTime(ol.getOrderTime())
                        .build())
                .collect(Collectors.toList());

        return orderInfo;
    }
}

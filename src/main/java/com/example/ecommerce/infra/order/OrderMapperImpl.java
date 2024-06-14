package com.example.ecommerce.infra.order;

import com.example.ecommerce.api.order.response.RetrieveOrderDetail;
import com.example.ecommerce.api.order.response.RetrieveOrderList;
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
                .city(order.getReceiver().getAddress().getCity())
                .street(order.getReceiver().getAddress().getStreet())
                .build();

        RetrieveOrderDetail.ReceiverInfo receiverInfo = RetrieveOrderDetail.ReceiverInfo.builder()
                .address(addressInfo)
                .build();

        List<RetrieveOrderDetail.OrderLineInfo> orderLineInfoList = order.getOrderLineList().stream()
                .map(orderLine -> RetrieveOrderDetail.OrderLineInfo.builder()
                        .id(orderLine.getId())
                        .name(orderLine.getName())
                        .unitPrice(orderLine.getUnitPrice())
                        .quantity(orderLine.getQuantity())
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
                .map(order -> RetrieveOrderList.OrderInfo.builder()
                        .id(order.getId())
                        .purchaser(RetrieveOrderList.PurchaserInfo.builder()
                                .memberId(order.getPurchaser().getMemberId())
                                .username(order.getPurchaser().getUsername())
                                .build())
                        .orderLine(RetrieveOrderList.OrderLineInfo.builder()
                                .id(order.getOrderLineList().get(0).getId())
                                .name(order.getOrderLineList().get(0).getName())
                                .build())
                        .orderPrice(order.getOrderPrice())
                        .orderTime(order.getOrderTime())
                        .build())
                .collect(Collectors.toList());

        return orderInfo;
    }
}

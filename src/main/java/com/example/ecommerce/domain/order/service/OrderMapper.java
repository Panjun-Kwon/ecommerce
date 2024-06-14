package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.api.order.response.RetrieveOrderDetail;
import com.example.ecommerce.api.order.response.RetrieveOrderList;
import com.example.ecommerce.domain.order.entity.order.Order;

import java.util.List;

public interface OrderMapper {
    RetrieveOrderDetail.OrderInfo retrieveDetailOf(Order order);

    List<RetrieveOrderList.OrderInfo> retrieveListOf(List<Order> orderList);
}

package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.api.order.request.*;
import com.example.ecommerce.api.order.response.*;
import com.example.ecommerce.domain.order.dto.*;
import com.example.ecommerce.domain.order.entity.order.*;

import java.util.*;

public interface OrderMapper {
    OrderDetailResponse.OrderInfo retrieveDetailOf(Order order);

    List<OrderListResponse.OrderInfo> retrieveListOf(List<Order> orderList);

    List<MemberOrderListResponse.OrderInfo> retrieveMemberOrderListOf(List<Order> memberOrderList);

    ShippingAddressCommand commandOf(ShippingAddressRequest request);

    RegisterCommand commandOf(RegisterRequest request);
}

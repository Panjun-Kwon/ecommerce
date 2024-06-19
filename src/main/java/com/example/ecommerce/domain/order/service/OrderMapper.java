package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.api.order.request.*;
import com.example.ecommerce.api.order.response.*;
import com.example.ecommerce.domain.order.dto.*;
import com.example.ecommerce.domain.order.entity.order.*;

import java.util.*;

public interface OrderMapper {
    OrderDetailResponse.OrderInfo retrieveDetailOf(Order order);

    List<OrderListResponse.OrderInfo> retrieveListOf(List<Order> orderList);

    List<MemberMyPageResponse.OrderInfo> retrieveMyPageListOf(List<Order> orderList);

    RegisterCommand commandOf(RegisterRequest request);
}

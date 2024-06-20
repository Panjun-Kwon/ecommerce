package com.example.ecommerce.app.order;

import com.example.ecommerce.api.order.response.*;
import com.example.ecommerce.domain.order.entity.order.*;
import com.example.ecommerce.domain.order.service.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderRetrieveService {

    private final OrderReader orderReader;
    private final OrderMapper orderMapper;

    public OrderDetailResponse retrieveOrderDetail(Long orderId) {
        Order order = orderReader.getOrder(orderId);
        OrderDetailResponse.OrderInfo orderInfo = orderMapper.retrieveDetailOf(order);

        return new OrderDetailResponse(orderInfo);
    }

    public OrderListResponse retrieveOrderList(Pageable pageable) {
        Page<Order> orderPage = orderReader.getOrderAll(pageable);
        List<OrderListResponse.OrderInfo> orderInfo = orderMapper.retrieveListOf(orderPage.getContent());

        OrderListResponse.PageInfo pageInfo = makePageInfo(orderPage);

        return new OrderListResponse(orderInfo, pageInfo);
    }

    private static OrderListResponse.PageInfo makePageInfo(Page<Order> orderPage) {
        return OrderListResponse.PageInfo.builder()
                .currentElements(orderPage.getNumberOfElements())
                .totalPages(orderPage.getTotalPages())
                .totalElements(orderPage.getTotalElements())
                .build();
    }

    public MemberOrderListResponse memberOrderList(Long memberId) {

        List<Order> memberOrderList = orderReader.getOrderByPurchaserId(memberId);
        List<MemberOrderListResponse.OrderInfo> memberOrderInfoList =
                orderMapper.retrieveMemberOrderListOf(memberOrderList);

        return new MemberOrderListResponse(memberOrderInfoList);
    }
}

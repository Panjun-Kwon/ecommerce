package com.example.ecommerce.app.order;

import com.example.ecommerce.api.order.response.RetrieveOrderDetail;
import com.example.ecommerce.api.order.response.RetrieveOrderList;
import com.example.ecommerce.domain.order.entity.order.Order;
import com.example.ecommerce.domain.order.service.OrderMapper;
import com.example.ecommerce.domain.order.service.OrderReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderRetrieveService {

    private final OrderReader orderReader;
    private final OrderMapper orderMapper;

    public RetrieveOrderDetail retrieveOrderDetail(Long orderId) {
        Order order = orderReader.getOrder(orderId);
        RetrieveOrderDetail.OrderInfo orderInfo = orderMapper.retrieveDetailOf(order);

        return new RetrieveOrderDetail(orderInfo);
    }

    public RetrieveOrderList retrieveOrderList(Pageable pageable) {
        Page<Order> orderPage = orderReader.getOrderAll(pageable);
        List<RetrieveOrderList.OrderInfo> orderInfo = orderMapper.retrieveListOf(orderPage.getContent());

        RetrieveOrderList.PageInfo pageInfo = makePageInfo(orderPage);

        return new RetrieveOrderList(orderInfo, pageInfo);
    }

    private static RetrieveOrderList.PageInfo makePageInfo(Page<Order> orderPage) {
        return RetrieveOrderList.PageInfo.builder()
                .currentElements(orderPage.getNumberOfElements())
                .totalPages(orderPage.getTotalPages())
                .totalElements(orderPage.getTotalElements())
                .build();
    }

}

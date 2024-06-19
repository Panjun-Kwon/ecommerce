package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.entity.order.*;
import org.springframework.data.domain.*;

import java.util.*;

public interface OrderReader {
    Order getOrder(Long orderId);

    Order getOrderFetch(Long orderId);

    Page<Order> getOrderAll(Pageable pageable);

    Page<Order> getOrderAllFetch(Pageable pageable);

    List<Order> getOrderByPurchaserId(Long memberId);
}

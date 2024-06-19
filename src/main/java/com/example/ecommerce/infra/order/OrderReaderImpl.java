package com.example.ecommerce.infra.order;

import com.example.ecommerce.common.exception.*;
import com.example.ecommerce.domain.order.entity.order.*;
import com.example.ecommerce.domain.order.service.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
@RequiredArgsConstructor
public class OrderReaderImpl implements OrderReader {

    private final OrderRepository orderRepository;

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_ENTITY,
                        String.format("해당 주문(%d)을 찾을 수 없음", orderId)));
    }

    @Override
    public Order getOrderFetch(Long orderId) {
        return orderRepository.findByIdFetch(orderId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_ENTITY,
                        String.format("해당 주문(%d)을 찾을 수 없음", orderId)));
    }

    @Override
    public Page<Order> getOrderAll(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public Page<Order> getOrderAllFetch(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    @Override
    public List<Order> getOrderByPurchaserId(Long memberId) {
        return orderRepository.findByPurchaserId(memberId);
    }
}

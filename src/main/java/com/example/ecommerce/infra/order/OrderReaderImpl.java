package com.example.ecommerce.infra.order;

import com.example.ecommerce.common.exception.CommonException;
import com.example.ecommerce.common.exception.ErrorCode;
import com.example.ecommerce.domain.order.entity.order.Order;
import com.example.ecommerce.domain.order.service.OrderReader;
import com.example.ecommerce.domain.order.service.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

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
}

package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

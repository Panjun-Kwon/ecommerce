package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o left join fetch o.orderLineList ol where o.id = :orderId")
    Optional<Order> findByIdFetch(@Param("orderId") Long orderId);
}

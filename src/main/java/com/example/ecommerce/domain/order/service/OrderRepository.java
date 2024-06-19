package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.entity.order.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;

import java.util.*;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o left join fetch o.orderLineList ol where o.id = :orderId")
    Optional<Order> findByIdFetch(@Param("orderId") Long orderId);

    @Query("select o from Order o where o.purchaser.memberId = :memberId")
    List<Order> findByPurchaserId(@Param("memberId") Long memberId);
}

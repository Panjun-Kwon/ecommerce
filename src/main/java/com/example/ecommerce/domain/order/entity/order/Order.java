package com.example.ecommerce.domain.order.entity.order;

import com.example.ecommerce.domain.order.entity.order_line.OrderLine;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Embedded
    private Purchaser purchaser;
    @Embedded
    private Receiver receiver;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLine;
    private int orderPrice;
    private LocalDateTime orderTime;
}

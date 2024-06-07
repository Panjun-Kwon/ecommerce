package com.example.ecommerce.domain.order.entity.order_line;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "order_lines")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class OrderLine {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "order_line_id")
    private Long id;

    private Long productId;
    private String name;
    private int unitPrice;
    private int quantity;
}

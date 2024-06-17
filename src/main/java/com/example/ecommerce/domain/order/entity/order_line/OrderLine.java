package com.example.ecommerce.domain.order.entity.order_line;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Builder;
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

    @Embedded
    private OrderProduct orderProduct;
    @Min(0)
    private Integer quantity;

    @Builder
    public OrderLine(OrderProduct orderProduct, Integer quantity) {
        this.orderProduct = orderProduct;
        this.quantity = quantity;
    }
}

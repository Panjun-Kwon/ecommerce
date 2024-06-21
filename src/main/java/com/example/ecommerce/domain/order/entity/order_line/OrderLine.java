package com.example.ecommerce.domain.order.entity.order_line;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name = "order_lines")
@Getter
@NoArgsConstructor
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

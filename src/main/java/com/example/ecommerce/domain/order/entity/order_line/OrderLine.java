package com.example.ecommerce.domain.order.entity.order_line;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

    @Column(updatable = false)
    @NotNull
    private Long productId;
    @Column(updatable = false)
    @NotNull
    private String name;
    @Min(0)
    private Integer unitPrice;
    @Min(0)
    private Integer quantity;

    @Builder
    private OrderLine(Long productId, String name, Integer unitPrice, Integer quantity) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
}

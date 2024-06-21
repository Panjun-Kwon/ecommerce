package com.example.ecommerce.domain.order.entity.order_line;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderProduct {
    @Column(name = "order_product_id", updatable = false)
    @NotNull
    private Long productId;
    @Column(name = "order_product_name", updatable = false)
    @NotNull
    private String name;
    @Column(name = "order_product_price")
    @Min(0)
    private Integer price;
}

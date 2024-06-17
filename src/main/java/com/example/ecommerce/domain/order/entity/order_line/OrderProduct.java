package com.example.ecommerce.domain.order.entity.order_line;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

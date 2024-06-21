package com.example.ecommerce.domain.order.entity.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Purchaser {
    @Column(name = "purchaser_id", updatable = false)
    @NotNull
    private Long memberId;
    @Column(name = "purchaser_username", updatable = false)
    @NotNull
    private String username;
}

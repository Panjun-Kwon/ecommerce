package com.example.ecommerce.domain.order.entity.order;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Purchaser {
    @Column(name = "purchaser_id", updatable = false)
    @NotNull
    private Long memberId;
    @Column(name = "purchaser_username", updatable = false)
    @NotNull
    private String username;
}

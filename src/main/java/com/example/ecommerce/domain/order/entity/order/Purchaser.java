package com.example.ecommerce.domain.order.entity.order;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Purchaser {
    @Column(name = "purchaser_id")
    private Long memberId;
    @Column(name = "purchaser_username")
    private String username;
}

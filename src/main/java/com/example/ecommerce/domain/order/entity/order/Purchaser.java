package com.example.ecommerce.domain.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Purchaser {
    @Column(name = "purchaser_id")
    private Long memberId;
    @Column(name = "purchaser_username")
    private Long username;
}

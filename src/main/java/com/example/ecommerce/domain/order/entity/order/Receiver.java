package com.example.ecommerce.domain.order.entity.order;

import jakarta.persistence.Embeddable;

@Embeddable
public class Receiver {
    private Address address;
}

package com.example.ecommerce.domain.order.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Receiver {
    private Address address;
}

package com.example.ecommerce.domain.order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "receiver_address_city")
    private String city;
    @Column(name = "receiver_address_street")
    private String street;
}

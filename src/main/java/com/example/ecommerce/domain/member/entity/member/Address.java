package com.example.ecommerce.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "address_city")
    private String city;
    @Column(name = "address_street")
    private String street;
}

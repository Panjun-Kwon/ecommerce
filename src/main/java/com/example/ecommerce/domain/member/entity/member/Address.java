package com.example.ecommerce.domain.member.entity.member;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Column(name = "address_city")
    private String city;
    @Column(name = "address_street")
    private String street;
}

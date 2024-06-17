package com.example.ecommerce.domain.member.entity.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    @Column(name = "address_city")
    private String city;
    @Column(name = "address_street")
    private String street;
}

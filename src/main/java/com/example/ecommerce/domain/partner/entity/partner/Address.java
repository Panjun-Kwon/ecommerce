package com.example.ecommerce.domain.partner.entity.partner;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    @Column(name = "address_city")
    @NotNull
    private String city;
    @Column(name = "address_street")
    @NotNull
    private String street;
}

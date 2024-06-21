package com.example.ecommerce.domain.partner.entity.partner;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Column(name = "address_city")
    @NotNull
    private String city;
    @Column(name = "address_street")
    @NotNull
    private String street;
}

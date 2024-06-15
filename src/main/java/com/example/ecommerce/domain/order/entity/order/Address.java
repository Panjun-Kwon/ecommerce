package com.example.ecommerce.domain.order.entity.order;

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
    @Column(name = "receiver_address_city")
    @NotNull
    private String city;
    @Column(name = "receiver_address_street")
    @NotNull
    private String street;
}

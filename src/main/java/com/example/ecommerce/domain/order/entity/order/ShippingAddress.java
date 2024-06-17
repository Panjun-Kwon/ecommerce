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
public class ShippingAddress {
    @Column(name = "shipping_address_city")
    @NotNull
    private String city;
    @Column(name = "shipping_address_street")
    @NotNull
    private String street;
}

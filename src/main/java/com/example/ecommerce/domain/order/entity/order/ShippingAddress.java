package com.example.ecommerce.domain.order.entity.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress {
    @Column(name = "shipping_address_city")
    @NotNull
    private String city;
    @Column(name = "shipping_address_street")
    @NotNull
    private String street;
}

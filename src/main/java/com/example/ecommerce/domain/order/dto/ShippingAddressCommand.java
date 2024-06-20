package com.example.ecommerce.domain.order.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class ShippingAddressCommand {
    private String city;
    private String street;
}

package com.example.ecommerce.domain.partner.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AddressCommand {
    private String city;
    private String street;
}

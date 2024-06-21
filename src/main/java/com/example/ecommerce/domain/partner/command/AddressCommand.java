package com.example.ecommerce.domain.partner.command;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class AddressCommand {
    private String city;
    private String street;
}
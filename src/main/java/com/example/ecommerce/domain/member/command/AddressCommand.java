package com.example.ecommerce.domain.member.command;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class AddressCommand {
    private String city;
    private String street;
}

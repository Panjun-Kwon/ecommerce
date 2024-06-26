package com.example.ecommerce.domain.partner.command;

import com.example.ecommerce.api.partner.request.*;
import com.example.ecommerce.domain.partner.entity.partner.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressCommand {
    private String city;
    private String street;

    public static AddressCommand of(AddressRequest request) {
        if (request == null) return new AddressCommand();
        return new AddressCommand(request.getCity(), request.getStreet());
    }

    public Address toAddress() {
        if (this == null) return new Address();
        return new Address(this.city, this.street);
    }
}

package com.example.ecommerce.domain.order.command;

import com.example.ecommerce.api.order.request.*;
import com.example.ecommerce.domain.order.entity.order.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddressCommand {
    private String city;
    private String street;

    public static ShippingAddressCommand of(ShippingAddressRequest request) {
        if (request == null) new ShippingAddressCommand();
        return ShippingAddressCommand.builder()
                .city(request.getCity())
                .street(request.getStreet())
                .build();
    }

    public static ShippingAddress toShippingAddress(ShippingAddressCommand command) {
        if (command == null) new ShippingAddress();
        return ShippingAddress.builder()
                .city(command.city)
                .street(command.street)
                .build();
    }
}

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
        return new ShippingAddressCommand(request.getCity(), request.getStreet());
    }

    public ShippingAddress toShippingAddress() {
        if (this == null) new ShippingAddress();
        return new ShippingAddress(this.city, this.street);
    }
}

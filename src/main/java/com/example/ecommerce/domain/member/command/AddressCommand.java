package com.example.ecommerce.domain.member.command;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.domain.member.entity.member.*;
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

        return AddressCommand.builder()
                .city(request.getCity())
                .street(request.getStreet())
                .build();
    }

    public Address toAddress() {
        if (this == null) return new Address();

        return Address.builder()
                .city(this.city)
                .street(this.street)
                .build();
    }
}

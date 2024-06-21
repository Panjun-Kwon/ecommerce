package com.example.ecommerce.domain.product.command;

import com.example.ecommerce.api.product.request.*;
import com.example.ecommerce.domain.product.entity.product.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCommand {

    private String name;
    private String description;
    private Integer price;
    private Integer stock;
    private RegistrantCommand registrant;

    public static RegisterCommand of(RegisterRequest request) {
        if (request == null) return new RegisterCommand();
        return RegisterCommand.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .registrant(RegistrantCommand.of(request.getRegistrant()))
                .build();
    }

    public static Product toProduct(RegisterCommand command) {
        if (command == null) return new Product();
        return Product.builder()
                .name(command.name)
                .description(command.description)
                .price(command.price)
                .stock(command.stock)
                .registrant(RegistrantCommand.toRegistrant(command.registrant))
                .build();
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegistrantCommand {
        private Long partnerId;
        private String name;

        public static RegistrantCommand of(RegisterRequest.RegistrantRequest request) {
            if (request == null) return new RegistrantCommand();
            return RegistrantCommand.builder()
                    .partnerId(request.getPartnerId())
                    .name(request.getName())
                    .build();
        }

        public static Registrant toRegistrant(RegistrantCommand command) {
            if (command == null) return new Registrant();
            return Registrant.builder()
                    .partnerId(command.partnerId)
                    .name(command.name)
                    .build();
        }
    }
}

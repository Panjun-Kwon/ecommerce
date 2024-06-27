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

    public Product toProduct() {
        if (this == null) return new Product();
        return Product.builder()
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .stock(this.stock)
                .registrant(this.registrant.toRegistrant())
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
            return new RegistrantCommand(request.getPartnerId(), request.getName());
        }

        public Registrant toRegistrant() {
            if (this == null) return new Registrant();
            return new Registrant(this.partnerId, this.name);
        }
    }
}

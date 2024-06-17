package com.example.ecommerce.infra.product;

import com.example.ecommerce.domain.product.dto.RegisterCommand;
import com.example.ecommerce.domain.product.entity.product.Product;
import com.example.ecommerce.domain.product.service.ProductFactory;
import com.example.ecommerce.domain.product.service.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductFactoryImpl implements ProductFactory {

    private final ProductValidator productValidator;

    @Override
    public Product make(RegisterCommand command) {

        productValidator.validate(command);

        return Product.builder()
                .name(command.getName())
                .price(command.getPrice())
                .stock(command.getStock())
                .registrant(command.getRegistrant())
                .build();
    }
}

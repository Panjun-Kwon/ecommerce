package com.example.ecommerce.infra.product;

import com.example.ecommerce.domain.product.dto.ProductCommand;
import com.example.ecommerce.domain.product.entity.product.Product;
import com.example.ecommerce.domain.product.service.ProductFactory;
import org.springframework.stereotype.Component;

@Component
public class ProductFactoryImpl implements ProductFactory {
    @Override
    public Product make(ProductCommand.Register command) {
        return Product.builder()
                .name(command.getName())
                .unitPrice(command.getUnitPrice())
                .stock(command.getStock())
                .partnerId(command.getPartnerId())
                .build();
    }
}

package com.example.ecommerce.infra.product;

import com.example.ecommerce.domain.product.command.*;
import com.example.ecommerce.domain.product.entity.product.*;
import com.example.ecommerce.domain.product.service.*;
import lombok.*;
import org.springframework.stereotype.*;

@Component
@RequiredArgsConstructor
public class ProductFactoryImpl implements ProductFactory {
    @Override
    public Product make(RegisterCommand command) {
        return RegisterCommand.toProduct(command);
    }
}

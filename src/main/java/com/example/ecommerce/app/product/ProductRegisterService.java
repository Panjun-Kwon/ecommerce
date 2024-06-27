package com.example.ecommerce.app.product;

import com.example.ecommerce.domain.product.command.*;
import com.example.ecommerce.domain.product.entity.product.*;
import com.example.ecommerce.domain.product.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@RequiredArgsConstructor
public class ProductRegisterService {

    private final ProductValidator productValidator;
    private final ProductStore productStore;

    @Transactional
    public Long register(RegisterCommand command) {
        productValidator.validateRegister(command);
        Product product = productStore.store(command.toProduct());
        return product.getId();
    }
}

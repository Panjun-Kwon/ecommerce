package com.example.ecommerce.app.product;

import com.example.ecommerce.api.product.request.*;
import com.example.ecommerce.api.product.response.*;
import com.example.ecommerce.domain.product.command.*;
import com.example.ecommerce.domain.product.entity.product.*;
import com.example.ecommerce.domain.product.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductRegisterService {

    private final ProductValidator productValidator;
    private final ProductFactory productFactory;
    private final ProductStore productStore;

    public ProductIdResponse register(RegisterRequest request) {
        RegisterCommand command = RegisterCommand.of(request);
        productValidator.validateRegister(command);
        Product initProduct = productFactory.make(command);
        Product product = productStore.store(initProduct);
        return new ProductIdResponse(product.getId());
    }
}

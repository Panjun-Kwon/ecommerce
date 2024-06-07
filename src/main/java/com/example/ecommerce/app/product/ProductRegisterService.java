package com.example.ecommerce.app.product;

import com.example.ecommerce.domain.product.dto.ProductCommand;
import com.example.ecommerce.domain.product.entity.product.Product;
import com.example.ecommerce.domain.product.service.ProductFactory;
import com.example.ecommerce.domain.product.service.ProductStore;
import com.example.ecommerce.domain.product.service.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductRegisterService {

    private final ProductFactory productFactory;
    private final ProductStore productStore;
    private final ProductValidator productValidator;

    public Long register(ProductCommand.Register command) {
        productValidator.validateName(command.getName());
        Product initProduct = productFactory.make(command);
        Product product = productStore.store(initProduct);
        return product.getId();
    }
}

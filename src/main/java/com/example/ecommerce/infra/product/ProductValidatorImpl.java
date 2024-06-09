package com.example.ecommerce.infra.product;

import com.example.ecommerce.domain.product.dto.ProductCommand;
import com.example.ecommerce.domain.product.service.ProductRepository;
import com.example.ecommerce.domain.product.service.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class ProductValidatorImpl implements ProductValidator {

    private final ProductRepository productRepository;

    @Override
    public void validate(ProductCommand.Register command) {
        validateName(command.getName());
        validateUnitPrice(command.getUnitPrice());
        validateStock(command.getStock());
        validateProductId(command.getPartnerId());
    }

    @Override
    public void validateName(String name) {
        if (!StringUtils.hasText(name)) {
            throw new RuntimeException("NAME IS REQUIRED");
        }

        if (productRepository.existsByName(name)) {
            throw new RuntimeException("NAME DUPLICATED");
        }
    }

    @Override
    public void validateUnitPrice(int unitPrice) {
        if (unitPrice < 0) {
            throw new RuntimeException("UNIT PRICE IS GREATER THAN 0");
        }
    }

    @Override
    public void validateStock(int stock) {
        if (stock < 0) {
            throw new RuntimeException("STOCK IS GREATER THAN 0");
        }
    }

    @Override
    public void validateProductId(Long productId) {
        if (productId == null) {
            throw new RuntimeException("PRODUCT ID IS REQUIRED");
        }
    }
}

package com.example.ecommerce.app.product;

import com.example.ecommerce.api.product.request.Register;
import com.example.ecommerce.domain.product.dto.ProductCommand;
import com.example.ecommerce.domain.product.entity.product.Product;
import com.example.ecommerce.domain.product.service.ProductFactory;
import com.example.ecommerce.domain.product.service.ProductMapper;
import com.example.ecommerce.domain.product.service.ProductStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductRegisterService {

    private final ProductFactory productFactory;
    private final ProductStore productStore;
    private final ProductMapper productMapper;

    public Long register(Register request) {
        ProductCommand.Register command = productMapper.commandOf(request);
        Product initProduct = productFactory.make(command);
        Product product = productStore.store(initProduct);
        return product.getId();
    }
}

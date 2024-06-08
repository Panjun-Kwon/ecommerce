package com.example.ecommerce.infra.product;

import com.example.ecommerce.domain.product.entity.product.Product;
import com.example.ecommerce.domain.product.service.ProductReader;
import com.example.ecommerce.domain.product.service.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductReaderImpl implements ProductReader {

    private final ProductRepository productRepository;

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("PRODUCT NOT FOUND"));
    }

    @Override
    public List<Product> getProductAll(List<Long> productIdList) {
        return productRepository.findAllById(productIdList);
    }
}

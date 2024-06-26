package com.example.ecommerce.infra.product;

import com.example.ecommerce.common.exception.*;
import com.example.ecommerce.domain.product.entity.product.*;
import com.example.ecommerce.domain.product.service.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
@RequiredArgsConstructor
public class ProductReaderImpl implements ProductReader {

    private final ProductRepository productRepository;

    @Override
    public Product getProduct(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_ENTITY,
                        String.format("해당 상품(%d)를 찾을 수 없음", productId)));
    }

    @Override
    public boolean existProduct(Long productId) {
        return productRepository.existsById(productId);
    }

    @Override
    public boolean existProductByName(String name) {
        return productRepository.existsByName(name);
    }

    @Override
    public Page<Product> getProductAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> getProductAllByIdList(List<Long> productIdList) {
        return productRepository.findAllById(productIdList);
    }
}

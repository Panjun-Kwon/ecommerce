package com.example.ecommerce.infra.product;

import com.example.ecommerce.common.exception.CommonException;
import com.example.ecommerce.common.exception.ErrorCode;
import com.example.ecommerce.domain.product.entity.product.Product;
import com.example.ecommerce.domain.product.service.ProductReader;
import com.example.ecommerce.domain.product.service.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public List<Product> getProductByIdList(List<Long> productIdList) {
        return productRepository.findAllById(productIdList);
    }

    @Override
    public Page<Product> getProductAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}

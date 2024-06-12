package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.product.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductReader {
    Product getProduct(Long productId);

    List<Product> getProductByIdList(List<Long> productIdList);

    Page<Product> getProductAll(Pageable pageable);
}

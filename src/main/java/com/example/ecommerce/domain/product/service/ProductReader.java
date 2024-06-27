package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.product.entity.product.*;
import org.springframework.data.domain.*;

import java.util.*;

public interface ProductReader {
    Product getProduct(Long productId);

    List<Product> getProductAllByIdList(List<Long> productIdList);

    Page<Product> getProductAll(Pageable pageable);

    boolean existProduct(Long productId);

    boolean existProductByName(String name);
}

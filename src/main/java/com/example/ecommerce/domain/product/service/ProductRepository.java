package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.product.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
}

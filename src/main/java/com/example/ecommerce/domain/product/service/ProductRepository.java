package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.product.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);

    @Modifying
    @Query("UPDATE Product p SET p.stock = p.stock - :num WHERE p.id = :id")
    void decreaseStockById(@Param("id") Long id, @Param("num") int num);

    @Modifying
    @Query("UPDATE Product p SET p.stock = p.stock + :num WHERE p.id = :id")
    void increaseStockById(@Param("id") Long id, @Param("num") int num);
}

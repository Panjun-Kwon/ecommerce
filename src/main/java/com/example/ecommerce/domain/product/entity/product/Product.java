package com.example.ecommerce.domain.product.entity.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "products")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(unique = true)
    @NotNull
    private String name;
    @Min(0)
    private int unitPrice;
    @Min(0)
    private int stock;
    @Column(updatable = false)
    @NotNull
    private Long partnerId;

    @Builder
    private Product(String name, int unitPrice, int stock, Long partnerId) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
        this.partnerId = partnerId;
    }

    public void increaseStock(int num) {
        this.stock = this.stock + num;
    }

    public void decreaseStock(int num) {
        this.stock = this.stock - num;
    }

}

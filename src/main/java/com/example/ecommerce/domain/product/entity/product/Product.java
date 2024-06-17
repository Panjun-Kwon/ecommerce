package com.example.ecommerce.domain.product.entity.product;

import com.example.ecommerce.common.exception.CommonException;
import com.example.ecommerce.common.exception.ErrorCode;
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
    @Lob
    private String description;
    @Min(0)
    private Integer price;
    @Min(0)
    private Integer stock;
    @Embedded
    private Registrant registrant;

    @Builder
    public Product(String name,
                   String description,
                   Integer price,
                   Integer stock,
                   Registrant registrant) {
        
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.registrant = registrant;
    }

    public void increaseStock(Integer num) {
        this.stock = this.stock + num;
    }

    public void decreaseStock(Integer num) {
        if (this.stock < num) {
            String message = String.format("PRODUCT(%d) IS OUT OF STOCK", id);
            throw new CommonException(ErrorCode.BUSINESS_FAIL, message);
        }
        this.stock = this.stock - num;
    }
}

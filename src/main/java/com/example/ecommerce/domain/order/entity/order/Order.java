package com.example.ecommerce.domain.order.entity.order;

import com.example.ecommerce.domain.order.entity.order_line.OrderLine;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderLine> orderLineList = new ArrayList<>();
    @Min(0)
    private Integer orderPrice;
    @Column(updatable = false)
    @NotNull
    private LocalDateTime orderTime;
    @Embedded
    private Purchaser purchaser;
    @Embedded
    private Receiver receiver;
    @Embedded
    private ShippingAddress shippingAddress;

    @Builder
    public Order(List<OrderLine> orderLineList,
                 Purchaser purchaser,
                 Receiver receiver,
                 ShippingAddress shippingAddress) {

        this.orderLineList = orderLineList;
        this.purchaser = purchaser;
        this.receiver = receiver;
        this.shippingAddress = shippingAddress;
        this.orderTime = LocalDateTime.now();
    }

    public void calculateOrderPrice() {
        this.orderPrice = orderLineList.stream()
                .mapToInt(ol -> ol.getOrderProduct().getPrice() * ol.getQuantity())
                .sum();
    }
}

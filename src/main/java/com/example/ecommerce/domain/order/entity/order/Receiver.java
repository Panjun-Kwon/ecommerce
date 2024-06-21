package com.example.ecommerce.domain.order.entity.order;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Embeddable
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Receiver {
    @Column(name = "receiver_name")
    @NotNull
    private String name;
    @Column(name = "receiver_phone_num")
    @NotNull
    private String phoneNum;
}

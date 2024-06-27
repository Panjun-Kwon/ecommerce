package com.example.ecommerce.app.order;

import com.example.ecommerce.domain.order.command.*;
import com.example.ecommerce.domain.order.entity.order.*;
import com.example.ecommerce.domain.order.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderModifyService {

    private final OrderReader orderReader;

    public void modifyShippingAddress(Long orderId, ShippingAddressCommand command) {
        Order order = orderReader.getOrder(orderId);
        order.modifyShippingAddress(command.toShippingAddress());
    }
}

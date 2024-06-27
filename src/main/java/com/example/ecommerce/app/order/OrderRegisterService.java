package com.example.ecommerce.app.order;

import com.example.ecommerce.domain.order.command.*;
import com.example.ecommerce.domain.order.entity.order.*;
import com.example.ecommerce.domain.order.service.*;
import com.example.ecommerce.domain.product.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@RequiredArgsConstructor
public class OrderRegisterService {

    private final OrderValidator orderValidator;
    private final OrderStore orderStore;
    private final ProductManager productManager;

    @Transactional
    public Long register(RegisterCommand command) {
        orderValidator.validateRegister(command);
        Order initOrder = command.toOrder();
        productManager.decreaseProductStock(initOrder);
        initOrder.calculateOrderPrice();
        Order order = orderStore.store(initOrder);
        return order.getId();
    }
}

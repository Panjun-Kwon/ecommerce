package com.example.ecommerce.app.order;

import com.example.ecommerce.api.order.request.*;
import com.example.ecommerce.domain.order.dto.*;
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
    private final OrderMapper orderMapper;

    public void modifyShippingAddress(Long orderId, ShippingAddressRequest request) {
        ShippingAddressCommand command = orderMapper.commandOf(request);
        Order order = orderReader.getOrder(orderId);
        order.modifyShippingAddress(new ShippingAddress(command.getCity(), command.getStreet()));
    }
}

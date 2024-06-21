package com.example.ecommerce.domain.order.service;

import com.example.ecommerce.domain.order.command.*;
import com.example.ecommerce.domain.order.entity.order.*;

public interface OrderFactory {
    Order make(RegisterCommand command);
}

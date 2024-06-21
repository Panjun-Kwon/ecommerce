package com.example.ecommerce.domain.product.service;

import com.example.ecommerce.domain.product.command.*;
import com.example.ecommerce.domain.product.entity.product.*;

public interface ProductFactory {
    Product make(RegisterCommand command);
}

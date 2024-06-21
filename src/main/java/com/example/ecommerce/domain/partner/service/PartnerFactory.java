package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.domain.partner.command.*;
import com.example.ecommerce.domain.partner.entity.partner.*;

public interface PartnerFactory {
    Partner make(RegisterCommand command);
}

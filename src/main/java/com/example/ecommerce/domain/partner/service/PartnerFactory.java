package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.domain.partner.dto.RegisterCommand;
import com.example.ecommerce.domain.partner.entity.partner.Partner;

public interface PartnerFactory {
    Partner make(RegisterCommand command);
}

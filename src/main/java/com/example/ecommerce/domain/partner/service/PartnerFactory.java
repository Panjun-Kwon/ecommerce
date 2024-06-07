package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.domain.partner.dto.PartnerCommand;
import com.example.ecommerce.domain.partner.entity.partner.Partner;

public interface PartnerFactory {
    Partner make(PartnerCommand.Register command);
}

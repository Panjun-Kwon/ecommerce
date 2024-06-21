package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.domain.partner.command.*;

public interface PartnerValidator {
    void validateRegister(RegisterCommand command);

    void validateName(String name);
}

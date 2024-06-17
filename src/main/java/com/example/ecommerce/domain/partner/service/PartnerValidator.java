package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.domain.partner.dto.RegisterCommand;

public interface PartnerValidator {
    void validate(RegisterCommand command);

    void validateName(String name);
}

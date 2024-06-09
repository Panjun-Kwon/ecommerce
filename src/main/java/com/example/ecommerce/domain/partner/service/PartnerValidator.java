package com.example.ecommerce.domain.partner.service;

import com.example.ecommerce.domain.partner.dto.PartnerCommand;

public interface PartnerValidator {
    void validate(PartnerCommand.Register command);

    void validateName(String name);
}

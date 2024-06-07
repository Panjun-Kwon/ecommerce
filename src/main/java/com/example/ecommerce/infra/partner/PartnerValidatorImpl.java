package com.example.ecommerce.infra.partner;

import com.example.ecommerce.domain.partner.service.PartnerRepository;
import com.example.ecommerce.domain.partner.service.PartnerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PartnerValidatorImpl implements PartnerValidator {

    private final PartnerRepository partnerRepository;

    @Override
    public void validateName(String name) {
        if (partnerRepository.existsByName(name)) {
            throw new RuntimeException("NAME DUPLICATED");
        }
    }
}

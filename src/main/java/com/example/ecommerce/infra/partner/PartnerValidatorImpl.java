package com.example.ecommerce.infra.partner;

import com.example.ecommerce.domain.partner.dto.PartnerCommand;
import com.example.ecommerce.domain.partner.service.PartnerRepository;
import com.example.ecommerce.domain.partner.service.PartnerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class PartnerValidatorImpl implements PartnerValidator {

    private final PartnerRepository partnerRepository;

    @Override
    public void validate(PartnerCommand.Register command) {
        validateName(command.getName());
    }

    @Override
    public void validateName(String name) {
        if (!StringUtils.hasText(name)) {
            throw new RuntimeException("NAME IS REQUIRED");
        }

        if (partnerRepository.existsByName(name)) {
            throw new RuntimeException("NAME DUPLICATED");
        }
    }
}

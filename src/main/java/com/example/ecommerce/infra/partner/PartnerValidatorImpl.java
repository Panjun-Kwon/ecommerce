package com.example.ecommerce.infra.partner;

import com.example.ecommerce.common.exception.CommonException;
import com.example.ecommerce.common.exception.ErrorCode;
import com.example.ecommerce.domain.partner.dto.PartnerCommand;
import com.example.ecommerce.domain.partner.service.PartnerRepository;
import com.example.ecommerce.domain.partner.service.PartnerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
        if (partnerRepository.existsByName(name)) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "NAME DUPLICATED");
        }
    }
}

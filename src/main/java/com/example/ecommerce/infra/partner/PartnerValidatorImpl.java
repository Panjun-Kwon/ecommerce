package com.example.ecommerce.infra.partner;

import com.example.ecommerce.common.exception.*;
import com.example.ecommerce.domain.partner.command.*;
import com.example.ecommerce.domain.partner.service.*;
import lombok.*;
import org.springframework.stereotype.*;

@Component
@RequiredArgsConstructor
public class PartnerValidatorImpl implements PartnerValidator {

    private final PartnerRepository partnerRepository;

    @Override
    public void validateRegister(RegisterCommand command) {
        validateName(command.getProfile().getName());
    }

    @Override
    public void validateName(String name) {
        if (partnerRepository.existsByProfileName(name)) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "NAME DUPLICATED");
        }
    }
}

package com.example.ecommerce.app.partner;

import com.example.ecommerce.domain.partner.command.*;
import com.example.ecommerce.domain.partner.entity.partner.*;
import com.example.ecommerce.domain.partner.service.*;
import lombok.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@RequiredArgsConstructor
public class PartnerRegisterService {

    private final PartnerValidator partnerValidator;
    private final PasswordEncoder passwordEncoder;
    private final PartnerStore partnerStore;

    @Transactional
    public Long register(RegisterCommand command) {
        partnerValidator.validateRegister(command);
        Partner initPartner = command.toPartner();
        initPartner.encodePassword(passwordEncoder);
        Partner partner = partnerStore.store(initPartner);
        return partner.getId();
    }
}

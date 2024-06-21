package com.example.ecommerce.app.partner;

import com.example.ecommerce.api.partner.request.*;
import com.example.ecommerce.api.partner.response.*;
import com.example.ecommerce.domain.partner.command.*;
import com.example.ecommerce.domain.partner.entity.partner.*;
import com.example.ecommerce.domain.partner.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
@RequiredArgsConstructor
public class PartnerRegisterService {

    private final PartnerValidator partnerValidator;
    private final PartnerFactory partnerFactory;
    private final PartnerStore partnerStore;

    public PartnerIdResponse register(RegisterRequest request) {
        RegisterCommand command = RegisterCommand.of(request);
        partnerValidator.validateRegister(command);
        Partner initPartner = partnerFactory.make(command);
        Partner partner = partnerStore.store(initPartner);
        return new PartnerIdResponse(partner.getId());
    }
}

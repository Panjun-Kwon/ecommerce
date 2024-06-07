package com.example.ecommerce.app.partner;

import com.example.ecommerce.domain.partner.dto.PartnerCommand;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.partner.service.PartnerFactory;
import com.example.ecommerce.domain.partner.service.PartnerStore;
import com.example.ecommerce.domain.partner.service.PartnerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PartnerRegisterService {
    private final PartnerFactory partnerFactory;
    private final PartnerStore partnerStore;
    private final PartnerValidator partnerValidator;
    public Long register(PartnerCommand.Register command) {
        partnerValidator.validateName(command.getName());
        Partner initPartner = partnerFactory.make(command);
        Partner partner = partnerStore.store(initPartner);
        return partner.getId();
    }
}

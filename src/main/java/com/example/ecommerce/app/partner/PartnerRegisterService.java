package com.example.ecommerce.app.partner;

import com.example.ecommerce.api.partner.request.RegisterRequest;
import com.example.ecommerce.domain.partner.dto.RegisterCommand;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.partner.service.PartnerFactory;
import com.example.ecommerce.domain.partner.service.PartnerMapper;
import com.example.ecommerce.domain.partner.service.PartnerStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PartnerRegisterService {

    private final PartnerFactory partnerFactory;
    private final PartnerStore partnerStore;
    private final PartnerMapper partnerMapper;

    public Long register(RegisterRequest request) {
        RegisterCommand command = partnerMapper.commandOf(request);
        Partner initPartner = partnerFactory.make(command);
        Partner partner = partnerStore.store(initPartner);
        return partner.getId();
    }
}

package com.example.ecommerce.app.partner;

import com.example.ecommerce.api.partner.request.Register;
import com.example.ecommerce.domain.partner.dto.PartnerCommand;
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

    public Long register(Register request) {
        PartnerCommand.Register command = partnerMapper.commandOf(request);
        Partner initPartner = partnerFactory.make(command);
        Partner partner = partnerStore.store(initPartner);
        return partner.getId();
    }
}

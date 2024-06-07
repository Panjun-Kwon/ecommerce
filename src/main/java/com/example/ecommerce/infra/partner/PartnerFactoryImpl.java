package com.example.ecommerce.infra.partner;

import com.example.ecommerce.domain.partner.dto.PartnerCommand;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.partner.service.PartnerFactory;
import org.springframework.stereotype.Component;

@Component
public class PartnerFactoryImpl implements PartnerFactory {
    @Override
    public Partner make(PartnerCommand.Register command) {
        return Partner.builder()
                .name(command.getName())
                .build();
    }
}

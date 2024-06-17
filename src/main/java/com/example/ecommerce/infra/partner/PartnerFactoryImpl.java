package com.example.ecommerce.infra.partner;

import com.example.ecommerce.domain.partner.dto.PartnerCommand;
import com.example.ecommerce.domain.partner.entity.partner.Partner;
import com.example.ecommerce.domain.partner.service.PartnerFactory;
import com.example.ecommerce.domain.partner.service.PartnerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PartnerFactoryImpl implements PartnerFactory {

    private final PartnerValidator partnerValidator;

    @Override
    public Partner make(PartnerCommand.Register command) {
        
        partnerValidator.validate(command);

        return Partner.builder()
                .username(command.getUsername())
                .password(command.getPassword())
                .name(command.getName())
                .phoneNum(command.getPhoneNum())
                .email(command.getEmail())
                .address(command.getAddress())
                .build();
    }
}

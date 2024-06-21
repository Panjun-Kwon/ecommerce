package com.example.ecommerce.infra.partner;

import com.example.ecommerce.domain.partner.command.*;
import com.example.ecommerce.domain.partner.entity.partner.*;
import com.example.ecommerce.domain.partner.service.*;
import lombok.*;
import org.springframework.stereotype.*;

@Component
@RequiredArgsConstructor
public class PartnerFactoryImpl implements PartnerFactory {
    @Override
    public Partner make(RegisterCommand command) {
        return RegisterCommand.toPartner(command);
    }
}

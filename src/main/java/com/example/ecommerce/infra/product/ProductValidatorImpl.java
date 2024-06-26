package com.example.ecommerce.infra.product;

import com.example.ecommerce.common.exception.*;
import com.example.ecommerce.domain.partner.service.*;
import com.example.ecommerce.domain.product.command.*;
import com.example.ecommerce.domain.product.service.*;
import lombok.*;
import org.springframework.stereotype.*;

@Component
@RequiredArgsConstructor
public class ProductValidatorImpl implements ProductValidator {

    private final ProductReader productReader;
    private final PartnerReader partnerReader;

    @Override
    public void validateRegister(RegisterCommand command) {
        validateName(command.getName());
        validateProductId(command.getRegistrant().getPartnerId());
    }

    @Override
    public void validateName(String name) {
        if (productReader.existProductByName(name)) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER,
                    String.format("해당 이름(%s) 상품 존재", name));
        }
    }

    @Override
    public void validateProductId(Long partnerId) {
        if (!partnerReader.existPartner(partnerId)) {
            throw new CommonException(ErrorCode.NOT_FOUND_ENTITY,
                    String.format("해당 파트너(%d)를 찾을 수 없음", partnerId));
        }
    }
}

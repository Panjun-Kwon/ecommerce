package com.example.ecommerce.infra.product;

import com.example.ecommerce.common.exception.CommonException;
import com.example.ecommerce.common.exception.ErrorCode;
import com.example.ecommerce.domain.partner.service.PartnerReader;
import com.example.ecommerce.domain.product.dto.ProductCommand;
import com.example.ecommerce.domain.product.service.ProductReader;
import com.example.ecommerce.domain.product.service.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductValidatorImpl implements ProductValidator {

    private final ProductReader productReader;
    private final PartnerReader partnerReader;

    @Override
    public void validate(ProductCommand.Register command) {
        validateName(command.getName());
        validateProductId(command.getRegistrant().getPartnerId());
    }

    @Override
    public void validateName(String name) {
        if (productReader.existProductByName(name)) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "NAME DUPLICATED");
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

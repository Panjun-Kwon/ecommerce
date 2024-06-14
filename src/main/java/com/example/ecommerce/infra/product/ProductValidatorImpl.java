package com.example.ecommerce.infra.product;

import com.example.ecommerce.common.exception.CommonException;
import com.example.ecommerce.common.exception.ErrorCode;
import com.example.ecommerce.domain.partner.service.PartnerReader;
import com.example.ecommerce.domain.product.dto.ProductCommand;
import com.example.ecommerce.domain.product.service.ProductReader;
import com.example.ecommerce.domain.product.service.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class ProductValidatorImpl implements ProductValidator {

    private final ProductReader productReader;
    private final PartnerReader partnerReader;

    @Override
    public void validate(ProductCommand.Register command) {
        validateName(command.getName());
        validateUnitPrice(command.getUnitPrice());
        validateStock(command.getStock());
        validateProductId(command.getPartnerId());
    }

    @Override
    public void validateName(String name) {
        if (!StringUtils.hasText(name)) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "NAME IS REQUIRED");
        }

        if (productReader.existProductByName(name)) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "NAME DUPLICATED");
        }
    }

    @Override
    public void validateUnitPrice(Integer unitPrice) {
        if (unitPrice < 0) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "UNIT PRICE IS GREATER THAN 0");
        }
    }

    @Override
    public void validateStock(Integer stock) {
        if (stock < 0) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "STOCK IS GREATER THAN 0");
        }
    }

    @Override
    public void validateProductId(Long partnerId) {
        if (partnerId == null) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "PARTNER ID IS REQUIRED");
        }

        if (!partnerReader.existPartner(partnerId)) {
            throw new CommonException(ErrorCode.NOT_FOUND_ENTITY,
                    String.format("해당 파트너(%d)를 찾을 수 없음", partnerId));
        }
    }
}

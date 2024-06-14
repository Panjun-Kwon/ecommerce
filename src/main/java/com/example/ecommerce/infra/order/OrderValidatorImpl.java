package com.example.ecommerce.infra.order;

import com.example.ecommerce.common.exception.CommonException;
import com.example.ecommerce.common.exception.ErrorCode;
import com.example.ecommerce.domain.member.service.MemberReader;
import com.example.ecommerce.domain.order.dto.OrderCommand;
import com.example.ecommerce.domain.order.service.OrderValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderValidatorImpl implements OrderValidator {
    @Override
    public void validate(OrderCommand.Register command) {
        validatePurchaserId(command.getPurchaserId());
        validatePurchaserUsername(command.getPurchaserUsername());
        validateOrderLineList(command.getOrderLineList());
    }

    @Override
    public void validatePurchaserId(Long purchaserId) {
        if (purchaserId == null) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "PURCHASER ID IS REQUIRED");
        }
    }

    @Override
    public void validatePurchaserUsername(String purchaserUsername) {
        if (!StringUtils.hasText(purchaserUsername)) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "PURCHASER USERNAME IS REQUIRED");
        }
    }

    @Override
    public void validateOrderLineList(List<OrderCommand.RegisterOrderLine> command) {
        if (command.isEmpty()) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "ORDER LINE IS REQUIRED");
        }

        command.stream().forEach(this::validateOrderLine);
    }

    @Override
    public void validateOrderLine(OrderCommand.RegisterOrderLine command) {
        validateProductId(command.getProductId());
        validateName(command.getName());
        validateUnitPrice(command.getUnitPrice());
        validateQuantity(command.getQuantity());
    }

    @Override
    public void validateProductId(Long productId) {
        if (productId == null) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "PRODUCT ID IS REQUIRED");
        }
    }

    @Override
    public void validateName(String name) {
        if (!StringUtils.hasText(name)) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "NAME IS REQUIRED");
        }
    }

    @Override
    public void validateUnitPrice(Integer unitPrice) {
        if (unitPrice < 0) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "UNIT PRICE IS GREATER THAN 0");
        }
    }

    @Override
    public void validateQuantity(Integer quantity) {
        if (quantity < 0) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "QUANTITY IS GREATER THAN 0");
        }
    }

}

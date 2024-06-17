package com.example.ecommerce.infra.order;

import com.example.ecommerce.common.exception.CommonException;
import com.example.ecommerce.common.exception.ErrorCode;
import com.example.ecommerce.domain.member.service.MemberReader;
import com.example.ecommerce.domain.order.dto.OrderLineCommand;
import com.example.ecommerce.domain.order.dto.RegisterCommand;
import com.example.ecommerce.domain.order.service.OrderValidator;
import com.example.ecommerce.domain.product.service.ProductReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderValidatorImpl implements OrderValidator {

    private final MemberReader memberReader;
    private final ProductReader productReader;

    @Override
    public void validate(RegisterCommand command) {
        validatePurchaserId(command.getPurchaser().getMemberId());
        command.getOrderLineList().stream().forEach(this::validateOrderLine);
    }

    @Override
    public void validatePurchaserId(Long purchaserId) {
        if (!memberReader.existMember(purchaserId)) {
            throw new CommonException(ErrorCode.NOT_FOUND_ENTITY,
                    String.format("해당 구매자(%d)를 찾을 수 없음", purchaserId));
        }
    }

    @Override
    public void validateOrderLine(OrderLineCommand command) {
        validateProductId(command.getOrderProduct().getProductId());
    }

    @Override
    public void validateProductId(Long productId) {
        if (!productReader.existProduct(productId)) {
            throw new CommonException(ErrorCode.NOT_FOUND_ENTITY,
                    String.format("해당 상품(%d)를 찾을 수 없음", productId));
        }
    }
}

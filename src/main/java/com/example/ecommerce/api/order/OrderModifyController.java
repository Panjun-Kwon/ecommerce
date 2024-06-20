package com.example.ecommerce.api.order;

import com.example.ecommerce.api.order.request.*;
import com.example.ecommerce.app.order.*;
import com.example.ecommerce.common.response.*;
import lombok.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderModifyController {

    private final OrderModifyService orderModifyService;

    @PutMapping("/auth/member/orders/{orderId}/shipping_address")
    public CommonResponse<Void> modifyShippingAddress(
            @PathVariable Long orderId,
            @Validated @RequestBody ShippingAddressRequest request) {

        orderModifyService.modifyShippingAddress(orderId, request);
        String message = String.format("주문(%d) 배송지 변경", orderId);

        return CommonResponse.success(message, null);
    }

}

package com.example.ecommerce.api.order;

import com.example.ecommerce.api.order.request.*;
import com.example.ecommerce.api.order.response.*;
import com.example.ecommerce.app.order.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.domain.order.command.*;
import jakarta.validation.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderRegisterController {

    private final OrderRegisterService orderRegisterService;

    @PostMapping
    public CommonResponse<OrderIdResponse> registerOrder(@Valid @RequestBody RegisterRequest request) {
        Long orderId = orderRegisterService.register(RegisterCommand.of(request));
        return CommonResponse.success("주문 등록", new OrderIdResponse(orderId));
    }

}

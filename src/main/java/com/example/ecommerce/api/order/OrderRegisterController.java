package com.example.ecommerce.api.order;

import com.example.ecommerce.api.order.request.*;
import com.example.ecommerce.api.order.response.*;
import com.example.ecommerce.app.order.*;
import com.example.ecommerce.common.response.*;
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
        OrderIdResponse data = orderRegisterService.register(request);
        String message = "주문 등록";

        return CommonResponse.success(message, data);
    }

}

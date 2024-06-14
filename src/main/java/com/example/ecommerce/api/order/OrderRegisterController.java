package com.example.ecommerce.api.order;

import com.example.ecommerce.app.order.OrderRegisterService;
import com.example.ecommerce.common.response.CommonResponse;
import com.example.ecommerce.domain.order.dto.OrderCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderRegisterController {

    private final OrderRegisterService orderRegisterService;

    @PostMapping
    public CommonResponse<Long> registerOrder(@RequestBody OrderCommand.Register command) {
        Long data = orderRegisterService.register(command);
        String message = String.format("주문 등록");

        return CommonResponse.success(message, data);
    }

}

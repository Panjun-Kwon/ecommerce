package com.example.ecommerce.api.order;

import com.example.ecommerce.api.order.response.*;
import com.example.ecommerce.app.order.*;
import com.example.ecommerce.common.response.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderRetrieveController {

    private final OrderRetrieveService orderRetrieveService;

    @GetMapping("/{orderId}")
    public CommonResponse<OrderDetailResponse> retrieveOrderDetail(@PathVariable Long orderId) {
        OrderDetailResponse data = orderRetrieveService.retrieveOrderDetail(orderId);
        String message = String.format("주문(%d) 상세 조회", orderId);

        return CommonResponse.success(message, data);
    }

    @GetMapping
    public CommonResponse<OrderListResponse> retrieveOrderList(Pageable pageable) {
        OrderListResponse data = orderRetrieveService.retrieveOrderList(pageable);
        String message = String.format("주문 목록 조회");

        return CommonResponse.success(message, data);
    }

}

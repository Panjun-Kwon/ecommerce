package com.example.ecommerce.api.order;

import com.example.ecommerce.api.order.response.*;
import com.example.ecommerce.app.order.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.config.security.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.security.core.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OrderRetrieveController {

    private final OrderRetrieveService orderRetrieveService;

    @GetMapping("/orders/{orderId}")
    public CommonResponse<OrderDetailResponse> retrieveOrderDetail(@PathVariable Long orderId) {
        OrderDetailResponse data = orderRetrieveService.retrieveOrderDetail(orderId);
        String message = String.format("주문(%d) 상세 조회", orderId);

        return CommonResponse.success(message, data);
    }

    @GetMapping("/orders")
    public CommonResponse<OrderListResponse> retrieveOrderList(Pageable pageable) {
        OrderListResponse data = orderRetrieveService.retrieveOrderList(pageable);
        String message = String.format("주문 목록 조회");

        return CommonResponse.success(message, data);
    }

    @GetMapping("/auth/member/orders")
    public CommonResponse<MemberOrderListResponse> retrieveMemberOrderList(
            @AuthenticationPrincipal AuthMember authMember) {

        Long memberId = authMember.getId();
        MemberOrderListResponse data = orderRetrieveService.memberOrderList(memberId);
        String message = String.format("멤버(%d)의 주문 내역 조회", memberId);

        return CommonResponse.success(message, data);
    }
}

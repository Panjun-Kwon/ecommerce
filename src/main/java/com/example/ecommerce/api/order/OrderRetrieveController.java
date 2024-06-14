package com.example.ecommerce.api.order;

import com.example.ecommerce.api.order.response.RetrieveOrderDetail;
import com.example.ecommerce.api.order.response.RetrieveOrderList;
import com.example.ecommerce.app.order.OrderRetrieveService;
import com.example.ecommerce.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderRetrieveController {

    private final OrderRetrieveService orderRetrieveService;

    @GetMapping("/{orderId}")
    public CommonResponse<RetrieveOrderDetail> retrieveOrderDetail(@PathVariable Long orderId) {
        RetrieveOrderDetail data = orderRetrieveService.retrieveOrderDetail(orderId);
        String message = String.format("주문(%d) 상세 조회", orderId);

        return CommonResponse.success(message, data);
    }

    @GetMapping
    public CommonResponse<RetrieveOrderList> retrieveOrderList(Pageable pageable) {
        RetrieveOrderList data = orderRetrieveService.retrieveOrderList(pageable);
        String message = String.format("주문 목록 조회");

        return CommonResponse.success(message, data);
    }

}

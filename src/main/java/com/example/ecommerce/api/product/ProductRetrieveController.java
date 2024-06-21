package com.example.ecommerce.api.product;

import com.example.ecommerce.api.product.response.*;
import com.example.ecommerce.app.product.*;
import com.example.ecommerce.common.response.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRetrieveController {

    private final ProductRetrieveService productRetrieveService;

    @GetMapping("/{productId}")
    public CommonResponse<RetrieveProductDetail> retrieveProductDetail(@PathVariable Long productId) {
        RetrieveProductDetail data = productRetrieveService.retrieveProductDetail(productId);
        String message = String.format("상품(%d) 상세 조회", productId);
        return CommonResponse.success(message, data);
    }

    @GetMapping
    public CommonResponse<RetrieveProductList> retrieveProductList(Pageable pageable) {
        RetrieveProductList data = productRetrieveService.retrieveProductList(pageable);
        String message = String.format("상품 목록 조회");
        return CommonResponse.success(message, data);
    }
}

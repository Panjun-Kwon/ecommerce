package com.example.ecommerce.api.product;

import com.example.ecommerce.api.product.response.RetrieveProductDetail;
import com.example.ecommerce.api.product.response.RetrieveProductList;
import com.example.ecommerce.app.product.ProductRetrieveService;
import com.example.ecommerce.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

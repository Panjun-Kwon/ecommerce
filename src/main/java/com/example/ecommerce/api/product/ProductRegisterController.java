package com.example.ecommerce.api.product;

import com.example.ecommerce.api.product.request.*;
import com.example.ecommerce.api.product.response.*;
import com.example.ecommerce.app.product.*;
import com.example.ecommerce.common.response.*;
import jakarta.validation.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRegisterController {

    private final ProductRegisterService productRegisterService;

    @PostMapping
    public CommonResponse<ProductIdResponse> registerProduct(@Valid @RequestBody RegisterRequest request) {
        ProductIdResponse data = productRegisterService.register(request);
        String message = String.format("상품 등록");

        return CommonResponse.success(message, data);
    }

}

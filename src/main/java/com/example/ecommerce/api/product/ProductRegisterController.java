package com.example.ecommerce.api.product;

import com.example.ecommerce.api.product.request.Register;
import com.example.ecommerce.app.product.ProductRegisterService;
import com.example.ecommerce.common.response.CommonResponse;
import com.example.ecommerce.domain.product.service.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRegisterController {

    private final ProductRegisterService productRegisterService;
    private final ProductMapper productMapper;

    @PostMapping
    public CommonResponse<Long> registerProduct(@Validated @RequestBody Register request) {
        Long data = productRegisterService.register(request);
        String message = String.format("상품 등록");

        return CommonResponse.success(message, data);
    }

}

package com.example.ecommerce.api.product;

import com.example.ecommerce.app.product.ProductRegisterService;
import com.example.ecommerce.common.response.CommonResponse;
import com.example.ecommerce.domain.product.dto.ProductCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductRegisterController {

    private final ProductRegisterService productRegisterService;

    @PostMapping
    public CommonResponse<Long> registerProduct(@RequestBody ProductCommand.Register command) {
        Long data = productRegisterService.register(command);
        String message = String.format("상품 등록");

        return CommonResponse.success(message, data);
    }

}

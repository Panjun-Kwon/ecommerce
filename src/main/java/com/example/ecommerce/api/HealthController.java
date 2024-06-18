package com.example.ecommerce.api;

import com.example.ecommerce.common.response.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    @GetMapping("/health")
    public CommonResponse<String> request() {
        return CommonResponse.success("request", "hi");
    }

    @GetMapping("/auth/health")
    public CommonResponse<String> authRequest() {
        return CommonResponse.success("auth request", "hi");
    }
}

package com.example.ecommerce.api;

import com.example.ecommerce.common.exception.CommonException;
import com.example.ecommerce.common.exception.ErrorCode;
import com.example.ecommerce.common.response.CommonResponse;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health")
public class HealthController {
    @PostMapping
    public CommonResponse<Request> health(@Validated @RequestBody(required = false) Request request) {
        return CommonResponse.success("비즈니스 성공", request);
    }

    @Getter
    public static class Request {
        @NotNull
        private String name;
        @Min(30)
        private int age;
    }

    @GetMapping("/business/success")
    public CommonResponse<String> businessSuccess() {
        return CommonResponse.success("비즈니스 성공", "data");
    }

    @GetMapping("/business/fail")
    public void businessFail() {
        throw new CommonException(ErrorCode.BUSINESS_FAIL);
    }

    @GetMapping("/error/client")
    public void clientError() {
        throw new CommonException(ErrorCode.CLIENT_ERROR);
    }

    @GetMapping("/error/server")
    public void serverError() {
        throw new CommonException(ErrorCode.SERVER_ERROR);
    }
}

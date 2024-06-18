package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.request.LoginRequest;
import com.example.ecommerce.app.member.MemberLoginService;
import com.example.ecommerce.common.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberLoginController {

    private final MemberLoginService memberLoginService;

    @PostMapping("/login")
    public CommonResponse<String> login(@Validated @RequestBody LoginRequest loginRequest) {
        String data = memberLoginService.login(loginRequest);
        String message = String.format("Access Token 발급");

        return CommonResponse.success(message, data);
    }

}

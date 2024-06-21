package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.app.member.*;
import com.example.ecommerce.common.response.*;
import jakarta.validation.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberLoginController {

    private final MemberLoginService memberLoginService;

    @PostMapping("/api/members/login")
    public CommonResponse<AccessTokenResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        AccessTokenResponse data = memberLoginService.login(loginRequest);
        String message = "로그인";
        return CommonResponse.success(message, data);
    }

}

package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.app.member.*;
import com.example.ecommerce.common.response.*;
import lombok.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberLoginController {

    private final MemberLoginService memberLoginService;

    @PostMapping("/login")
    public CommonResponse<AccessTokenResponse> login(@Validated @RequestBody LoginRequest loginRequest) {
        AccessTokenResponse data = new AccessTokenResponse(memberLoginService.login(loginRequest));
        String message = "로그인";
        return CommonResponse.success(message, data);
    }

}

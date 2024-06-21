package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.app.member.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.config.security.*;
import lombok.*;
import org.springframework.security.core.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberModifyController {

    private final MemberModifyService memberModifyService;

    @PutMapping("/api/auth/members/my/password")
    public CommonResponse<Void> modifyPassword(
            @AuthenticationPrincipal AuthMember authMember,
            @RequestParam String password) {

        Long memberId = authMember.getId();
        memberModifyService.modifyPassword(memberId, password);
        String message = String.format("멤버(%d) 비밀번호 수정", memberId);
        return CommonResponse.success(message, null);
    }

    @PutMapping("/api/auth/members/my/email")
    public CommonResponse<Void> modifyEmail(
            @AuthenticationPrincipal AuthMember authMember,
            @RequestParam String email) {

        Long memberId = authMember.getId();
        memberModifyService.modifyEmail(memberId, email);
        String message = String.format("멤버(%d) 이메일 수정", memberId);
        return CommonResponse.success(message, null);
    }

    @PutMapping("/api/auth/members/my/phone_num")
    public CommonResponse<Void> modifyPhoneNum(
            @AuthenticationPrincipal AuthMember authMember,
            @RequestParam String phoneNum) {

        Long memberId = authMember.getId();
        memberModifyService.modifyPhoneNum(memberId, phoneNum);
        String message = String.format("멤버(%d) 전화번호 수정", memberId);
        return CommonResponse.success(message, null);
    }

    @PutMapping("/api/auth/members/my/address")
    public CommonResponse<Void> modifyAddress(
            @AuthenticationPrincipal AuthMember authMember,
            @Validated @RequestBody AddressRequest address) {

        Long memberId = authMember.getId();
        memberModifyService.modifyAddress(memberId, address);
        String message = String.format("멤버(%d) 전화번호 수정", memberId);
        return CommonResponse.success(message, null);
    }
}

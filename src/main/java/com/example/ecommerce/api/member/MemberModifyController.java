package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.app.member.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.config.security.*;
import com.example.ecommerce.domain.member.command.*;
import jakarta.validation.*;
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
            @Valid @RequestBody PasswordRequest request) {

        Long memberId = authMember.getId();
        memberModifyService.modifyPassword(memberId, request.getPassword());
        String message = String.format("멤버(%d) 비밀번호 수정", memberId);

        return CommonResponse.success(message, null);
    }

    @PutMapping("/api/auth/members/my/email")
    public CommonResponse<Void> modifyEmail(
            @AuthenticationPrincipal AuthMember authMember,
            @Valid @RequestBody EmailRequest request) {

        Long memberId = authMember.getId();
        memberModifyService.modifyEmail(memberId, request.getEmail());
        String message = String.format("멤버(%d) 이메일 수정", memberId);

        return CommonResponse.success(message, null);
    }

    @PutMapping("/api/auth/members/my/phone_num")
    public CommonResponse<Void> modifyPhoneNum(
            @AuthenticationPrincipal AuthMember authMember,
            @Valid @RequestBody PhoneNumRequest request) {

        Long memberId = authMember.getId();
        memberModifyService.modifyPhoneNum(memberId, request.getPhoneNum());
        String message = String.format("멤버(%d) 전화번호 수정", memberId);

        return CommonResponse.success(message, null);
    }

    @PutMapping("/api/auth/members/my/address")
    public CommonResponse<Void> modifyAddress(
            @AuthenticationPrincipal AuthMember authMember,
            @Validated @RequestBody AddressRequest request) {

        Long memberId = authMember.getId();
        memberModifyService.modifyAddress(memberId, AddressCommand.of(request));
        String message = String.format("멤버(%d) 전화번호 수정", memberId);

        return CommonResponse.success(message, null);
    }
}

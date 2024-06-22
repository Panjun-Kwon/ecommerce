package com.example.ecommerce.api.partner;

import com.example.ecommerce.api.partner.request.*;
import com.example.ecommerce.app.partner.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.config.security.*;
import jakarta.validation.*;
import lombok.*;
import org.springframework.security.core.annotation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PartnerModifyController {

    private final PartnerModifyService partnerModifyService;

    @PutMapping("/api/auth/partners/my/password")
    public CommonResponse<Void> modifyPassword(
            @AuthenticationPrincipal AuthPartner authPartner,
            @Valid @RequestBody PasswordRequest request) {

        Long partnerId = authPartner.getId();
        partnerModifyService.modifyPassword(partnerId, request.getPassword());
        String message = String.format("파트너(%d) 비밀번호 수정", partnerId);
        return CommonResponse.success(message, null);
    }

    @PutMapping("/api/auth/partners/my/email")
    public CommonResponse<Void> modifyEmail(
            @AuthenticationPrincipal AuthPartner authPartner,
            @Valid @RequestBody EmailRequest request) {

        Long partnerId = authPartner.getId();
        partnerModifyService.modifyEmail(partnerId, request.getEmail());
        String message = String.format("파트너(%d) 이메일 수정", partnerId);
        return CommonResponse.success(message, null);
    }

    @PutMapping("/api/auth/partners/my/phone_num")
    public CommonResponse<Void> modifyPhoneNum(
            @AuthenticationPrincipal AuthPartner authPartner,
            @Valid @RequestBody PhoneNumRequest request) {

        Long partnerId = authPartner.getId();
        partnerModifyService.modifyPhoneNum(partnerId, request.getPhoneNum());
        String message = String.format("파트너(%d) 전화번호 수정", partnerId);
        return CommonResponse.success(message, null);
    }

    @PutMapping("/api/auth/partners/my/address")
    public CommonResponse<Void> modifyAddress(
            @AuthenticationPrincipal AuthPartner authPartner,
            @Validated @RequestBody AddressRequest address) {

        Long partnerId = authPartner.getId();
        partnerModifyService.modifyAddress(partnerId, address);
        String message = String.format("파트너(%d) 전화번호 수정", partnerId);
        return CommonResponse.success(message, null);
    }
}

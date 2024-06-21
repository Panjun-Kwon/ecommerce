package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.app.member.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.config.security.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.security.core.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberRetrieveController {

    private final MemberRetrieveService memberRetrieveService;

    @GetMapping("/api/members/{memberId}")
    public CommonResponse<MemberDetailResponse> retrieveMemberDetail(@PathVariable Long memberId) {
        MemberDetailResponse data = memberRetrieveService.retrieveMemberDetail(memberId);
        String message = String.format("멤버(%d) 상세 조회", memberId);
        return CommonResponse.success(message, data);
    }

    @GetMapping("/api/members")
    public CommonResponse<MemberListResponse> retrieveMemberList(Pageable pageable) {
        MemberListResponse data = memberRetrieveService.retrieveMemberList(pageable);
        String message = "멤버 목록 조회";
        return CommonResponse.success(message, data);
    }

    @GetMapping("/api/auth/members/my/page")
    public CommonResponse<MemberPageResponse> retrievePage(@AuthenticationPrincipal AuthMember authMember) {
        Long memberId = authMember.getId();
        MemberPageResponse data = memberRetrieveService.retrieveMemberPage(memberId);
        String message = String.format("멤버(%d) 마이 페이지 조회", memberId);
        return CommonResponse.success(message, data);
    }

    @GetMapping("/api/auth/members/my/profile")
    public CommonResponse<MemberProfileResponse> retrieveProfile(@AuthenticationPrincipal AuthMember authMember) {
        Long memberId = authMember.getId();
        MemberProfileResponse data = memberRetrieveService.retrieveMemberProfile(memberId);
        String message = String.format("멤버(%d) 마이 프로필 조회", memberId);
        return CommonResponse.success(message, data);
    }
}

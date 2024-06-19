package com.example.ecommerce.api.member;

import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.app.member.*;
import com.example.ecommerce.common.response.*;
import com.example.ecommerce.domain.member.entity.member.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.security.core.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberRetrieveController {

    private final MemberRetrieveService memberRetrieveService;

    @GetMapping("/members/{memberId}")
    public CommonResponse<MemberDetailResponse> retrieveMemberDetail(@PathVariable Long memberId) {
        MemberDetailResponse data = memberRetrieveService.retrieveMemberDetail(memberId);
        String message = String.format("멤버(%d) 상세 조회", memberId);
        return CommonResponse.success(message, data);
    }

    @GetMapping("/members")
    public CommonResponse<MemberListResponse> retrieveMemberList(Pageable pageable) {
        MemberListResponse data = memberRetrieveService.retrieveMemberList(pageable);
        String message = "멤버 목록 조회";
        return CommonResponse.success(message, data);
    }

    @GetMapping("/auth/members/my/page")
    public CommonResponse<MemberMyPageResponse> retrieveMyPage(@AuthenticationPrincipal AuthMember authMember) {
        Long memberId = authMember.getMember().getId();
        MemberMyPageResponse data = memberRetrieveService.retrieveMemberMyPage(memberId);
        String message = String.format("멤버(%d) 마이 페이지 조회", memberId);
        return CommonResponse.success(message, data);
    }
}

package com.example.ecommerce.app.member;

import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.api.order.response.*;
import com.example.ecommerce.app.order.*;
import com.example.ecommerce.domain.member.entity.member.*;
import com.example.ecommerce.domain.member.service.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberRetrieveService {

    private final MemberReader memberReader;
    private final MemberMapper memberMapper;
    private final OrderRetrieveService orderRetrieveService;

    public MemberDetailResponse retrieveMemberDetail(Long memberId) {
        Member member = memberReader.getMember(memberId);
        MemberDetailResponse.MemberInfo memberInfo = memberMapper.memberDetailOf(member);

        return new MemberDetailResponse(memberInfo);
    }

    public MemberListResponse retrieveMemberList(Pageable pageable) {
        Page<Member> memberPage = memberReader.getMemberAll(pageable);
        List<MemberListResponse.MemberInfo> memberInfoList = memberMapper.memberListOf(memberPage.getContent());

        MemberListResponse.PageInfo pageInfo = makePageInfo(memberPage);

        return new MemberListResponse(memberInfoList, pageInfo);
    }

    private static MemberListResponse.PageInfo makePageInfo(Page<Member> memberPage) {
        return MemberListResponse.PageInfo.builder()
                .currentElements(memberPage.getNumberOfElements())
                .totalPages(memberPage.getTotalPages())
                .totalElements(memberPage.getTotalElements())
                .build();
    }

    public MemberPageResponse retrieveMemberPage(Long memberId) {
        Member member = memberReader.getMember(memberId);
        MemberPageResponse.MemberInfo memberInfo = memberMapper.memberPageOf(member);
        List<MemberOrderListResponse.OrderInfo> orderInfoList = orderRetrieveService.memberOrderList(memberId).getOrderList();

        return new MemberPageResponse(memberInfo, orderInfoList);
    }

    public MemberProfileResponse retrieveMemberProfile(Long memberId) {
        Member member = memberReader.getMember(memberId);
        MemberProfileResponse.ProfileInfo profileInfo = memberMapper.memberProfileOf(member);

        return new MemberProfileResponse(memberId, profileInfo);
    }
}

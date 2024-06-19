package com.example.ecommerce.app.member;

import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.domain.member.entity.member.*;
import com.example.ecommerce.domain.member.service.*;
import com.example.ecommerce.domain.order.entity.order.*;
import com.example.ecommerce.domain.order.service.*;
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
    private final OrderReader orderReader;
    private final MemberMapper memberMapper;
    private final OrderMapper orderMapper;

    public MemberDetailResponse retrieveMemberDetail(Long memberId) {
        Member member = memberReader.getMember(memberId);
        MemberDetailResponse.MemberInfo memberInfo = memberMapper.retrieveDetailOf(member);

        return new MemberDetailResponse(memberInfo);
    }

    public MemberListResponse retrieveMemberList(Pageable pageable) {
        Page<Member> memberPage = memberReader.getMemberAll(pageable);
        List<MemberListResponse.MemberInfo> memberInfoList = memberMapper.retrieveListOf(memberPage.getContent());

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

    public MemberMyPageResponse retrieveMemberMyPage(Long memberId) {
        Member member = memberReader.getMember(memberId);
        MemberMyPageResponse.MemberInfo memberInfo = memberMapper.retrieveMyPageDetailOf(member);
        List<Order> orderList = orderReader.getOrderByPurchaserId(memberId);
        List<MemberMyPageResponse.OrderInfo> orderInfoList = orderMapper.retrieveMyPageListOf(orderList);

        return new MemberMyPageResponse(memberInfo, orderInfoList);
    }
}

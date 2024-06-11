package com.example.ecommerce.app.member;

import com.example.ecommerce.api.member.dto.MemberResponse;
import com.example.ecommerce.domain.member.dto.MemberInfo;
import com.example.ecommerce.domain.member.entity.member.Member;
import com.example.ecommerce.domain.member.service.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberRetrieveService {

    private final MemberReader memberReader;

    public MemberResponse.MemberList retrieveMemberList(Pageable pageable) {
        Page<Member> memberList = memberReader.getMemberAll(pageable);

        List<MemberResponse.MemberDetail> responseList = memberList.stream()
                .map(member -> MemberResponse.MemberDetail.builder()
                        .member(MemberInfo.of(member))
                        .build())
                .collect(Collectors.toList());

        return MemberResponse.MemberList.builder()
                .memberList(responseList)
                .pageNumber(pageable.getPageNumber())
                .pageSize(pageable.getPageSize())
                .totalPages(memberList.getTotalPages())
                .totalElements(memberList.getTotalElements())
                .build();
    }

    public MemberResponse.MemberDetail retrieveMemberDetail(Long memberId) {
        Member member = memberReader.getMember(memberId);

        return MemberResponse.MemberDetail.builder()
                .member(MemberInfo.detailOf(member))
                .build();
    }
}

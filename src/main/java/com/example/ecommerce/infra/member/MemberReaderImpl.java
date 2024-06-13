package com.example.ecommerce.infra.member;

import com.example.ecommerce.common.exception.CommonException;
import com.example.ecommerce.common.exception.ErrorCode;
import com.example.ecommerce.domain.member.entity.member.Member;
import com.example.ecommerce.domain.member.service.MemberReader;
import com.example.ecommerce.domain.member.service.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberReaderImpl implements MemberReader {

    private final MemberRepository memberRepository;

    @Override
    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_ENTITY,
                        String.format("해당 멤버(%d)를 찾을 수 없음", memberId)));
    }

    @Override
    public Page<Member> getMemberAll(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }
}

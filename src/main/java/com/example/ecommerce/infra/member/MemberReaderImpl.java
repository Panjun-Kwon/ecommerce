package com.example.ecommerce.infra.member;

import com.example.ecommerce.common.exception.*;
import com.example.ecommerce.domain.member.entity.member.*;
import com.example.ecommerce.domain.member.service.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

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
    public Member getMemberByUsername(String username) {
        return memberRepository.findByUsername(username)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_ENTITY,
                        String.format("해당 멤버(%s)를 찾을 수 없음", username)));
    }

    @Override
    public boolean existMember(Long purchaserId) {
        return memberRepository.existsById(purchaserId);
    }

    @Override
    public Page<Member> getMemberAll(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }
}

package com.example.ecommerce.infra.member;

import com.example.ecommerce.domain.member.entity.member.Member;
import com.example.ecommerce.domain.member.service.MemberRepository;
import com.example.ecommerce.domain.member.service.MemberStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberStoreImpl implements MemberStore {

    private final MemberRepository memberRepository;

    @Override
    public Member store(Member initMember) {
        return memberRepository.save(initMember);
    }
}

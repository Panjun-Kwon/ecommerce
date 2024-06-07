package com.example.ecommerce.infra.member;

import com.example.ecommerce.domain.member.service.MemberRepository;
import com.example.ecommerce.domain.member.service.MemberValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberValidatorImpl implements MemberValidator {

    private final MemberRepository memberRepository;

    @Override
    public void validateUsername(String username) {
        if (memberRepository.existsByUsername(username)) {
            throw new RuntimeException("USERNAME DUPLICATED");
        }
    }
}

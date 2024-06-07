package com.example.ecommerce.app.member;

import com.example.ecommerce.domain.member.dto.MemberCommand;
import com.example.ecommerce.domain.member.entity.member.Member;
import com.example.ecommerce.domain.member.service.MemberFactory;
import com.example.ecommerce.domain.member.service.MemberStore;
import com.example.ecommerce.domain.member.service.MemberValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberSignUpService {

    private final MemberStore memberStore;
    private final MemberFactory memberFactory;
    private final MemberValidator memberValidator;

    public Long signUp(MemberCommand.SignUp command) {
        memberValidator.validateUsername(command.getUsername());
        Member initMember = memberFactory.make(command);
        Member member = memberStore.store(initMember);
        return member.getId();
    }
}
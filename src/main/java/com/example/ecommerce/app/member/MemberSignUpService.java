package com.example.ecommerce.app.member;

import com.example.ecommerce.api.member.request.SignUp;
import com.example.ecommerce.domain.member.dto.MemberCommand;
import com.example.ecommerce.domain.member.entity.member.Member;
import com.example.ecommerce.domain.member.service.MemberFactory;
import com.example.ecommerce.domain.member.service.MemberMapper;
import com.example.ecommerce.domain.member.service.MemberStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberSignUpService {

    private final MemberFactory memberFactory;
    private final MemberStore memberStore;
    private final MemberMapper memberMapper;

    public Long signUp(SignUp request) {
        MemberCommand.SignUp command = memberMapper.commandOf(request);
        Member initMember = memberFactory.make(command);
        Member member = memberStore.store(initMember);
        return member.getId();
    }
}
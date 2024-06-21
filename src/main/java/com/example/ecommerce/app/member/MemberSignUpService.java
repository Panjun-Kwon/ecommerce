package com.example.ecommerce.app.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.api.member.response.*;
import com.example.ecommerce.domain.member.command.*;
import com.example.ecommerce.domain.member.entity.member.*;
import com.example.ecommerce.domain.member.service.*;
import lombok.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberSignUpService {

    private final MemberValidator memberValidator;
    private final MemberFactory memberFactory;
    private final PasswordEncoder passwordEncoder;
    private final MemberStore memberStore;

    public MemberIdResponse signUp(SignUpRequest request) {
        SignUpCommand command = SignUpCommand.of(request);
        memberValidator.validateSignUpCommand(command);
        Member initMember = memberFactory.make(command);
        initMember.encodePassword(passwordEncoder);
        Member member = memberStore.store(initMember);
        return new MemberIdResponse(member.getId());
    }
}
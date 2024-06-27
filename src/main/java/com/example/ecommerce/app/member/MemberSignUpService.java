package com.example.ecommerce.app.member;

import com.example.ecommerce.domain.member.command.*;
import com.example.ecommerce.domain.member.entity.member.*;
import com.example.ecommerce.domain.member.service.*;
import lombok.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@RequiredArgsConstructor
public class MemberSignUpService {

    private final MemberValidator memberValidator;
    private final PasswordEncoder passwordEncoder;
    private final MemberStore memberStore;

    @Transactional
    public Long signUp(SignUpCommand command) {
        memberValidator.validateSignUp(command);
        Member initMember = command.toMember();
        initMember.encodePassword(passwordEncoder);
        Member member = memberStore.store(initMember);
        return member.getId();
    }
}
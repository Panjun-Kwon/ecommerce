package com.example.ecommerce.infra.member;

import com.example.ecommerce.domain.member.dto.MemberCommand;
import com.example.ecommerce.domain.member.entity.member.Member;
import com.example.ecommerce.domain.member.service.MemberFactory;
import com.example.ecommerce.domain.member.service.MemberValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberFactoryImpl implements MemberFactory {

    private final MemberValidator memberValidator;

    @Override
    public Member make(MemberCommand.SignUp command) {

        memberValidator.validate(command);

        return Member.builder()
                .username(command.getUsername())
                .password(command.getPassword())
                .name(command.getName())
                .phoneNum(command.getPhoneNum())
                .email(command.getEmail())
                .address(command.getAddress())
                .build();
    }
}

package com.example.ecommerce.infra.member;

import com.example.ecommerce.domain.member.dto.MemberCommand;
import com.example.ecommerce.domain.member.entity.member.Member;
import com.example.ecommerce.domain.member.service.MemberFactory;
import org.springframework.stereotype.Component;

@Component
public class MemberFactoryImpl implements MemberFactory {
    @Override
    public Member make(MemberCommand.SignUp command) {
        return Member.builder()
                .username(command.getUsername())
                .build();
    }
}

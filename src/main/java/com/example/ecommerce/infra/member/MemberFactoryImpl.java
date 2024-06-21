package com.example.ecommerce.infra.member;

import com.example.ecommerce.domain.member.command.*;
import com.example.ecommerce.domain.member.entity.member.*;
import com.example.ecommerce.domain.member.service.*;
import org.springframework.stereotype.*;

@Component
public class MemberFactoryImpl implements MemberFactory {
    @Override
    public Member make(SignUpCommand command) {
        Member member = SignUpCommand.toEntity(command);
        return member;
    }
}

package com.example.ecommerce.infra.member;

import com.example.ecommerce.domain.member.dto.SignUpCommand;
import com.example.ecommerce.domain.member.entity.member.Address;
import com.example.ecommerce.domain.member.entity.member.Member;
import com.example.ecommerce.domain.member.service.MemberFactory;
import com.example.ecommerce.domain.member.service.MemberValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberFactoryImpl implements MemberFactory {

    private final MemberValidator memberValidator;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Member make(SignUpCommand command) {

        memberValidator.validate(command);

        Address address = Address.builder()
                .city(command.getAddress().getCity())
                .street(command.getAddress().getStreet())
                .build();

        Member member = Member.builder()
                .username(command.getUsername())
                .password(passwordEncoder.encode(command.getPassword()))
                .name(command.getName())
                .phoneNum(command.getPhoneNum())
                .email(command.getEmail())
                .address(address)
                .build();

        return member;
    }
}

package com.example.ecommerce.infra.member;

import com.example.ecommerce.domain.member.dto.*;
import com.example.ecommerce.domain.member.entity.member.*;
import com.example.ecommerce.domain.member.service.*;
import lombok.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

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

        Profile profile = Profile.builder()
                .name(command.getName())
                .email(command.getEmail())
                .phoneNum(command.getPhoneNum())
                .build();

        Member member = Member.builder()
                .username(command.getUsername())
                .password(passwordEncoder.encode(command.getPassword()))
                .profile(profile)
                .address(address)
                .build();

        return member;
    }
}

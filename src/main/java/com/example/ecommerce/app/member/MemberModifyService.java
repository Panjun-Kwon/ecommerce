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
public class MemberModifyService {

    private final MemberReader memberReader;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void modifyPassword(Long memberId, String password) {
        Member member = memberReader.getMember(memberId);
        member.modifyPassword(password);
        member.encodePassword(passwordEncoder);
    }

    @Transactional
    public void modifyEmail(Long memberId, String email) {
        Member member = memberReader.getMember(memberId);
        member.modifyEmail(email);
    }

    @Transactional
    public void modifyPhoneNum(Long memberId, String phoneNum) {
        Member member = memberReader.getMember(memberId);
        member.modifyPhoneNum(phoneNum);
    }

    @Transactional
    public void modifyAddress(Long memberId, AddressCommand command) {
        Member member = memberReader.getMember(memberId);
        Address address = command.toAddress();
        member.modifyAddress(address);
    }
}

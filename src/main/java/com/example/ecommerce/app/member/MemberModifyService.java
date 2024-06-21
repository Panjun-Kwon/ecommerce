package com.example.ecommerce.app.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.domain.member.entity.member.*;
import com.example.ecommerce.domain.member.service.*;
import lombok.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberModifyService {

    private final MemberReader memberReader;
    private final PasswordEncoder passwordEncoder;

    public void modifyPassword(Long memberId, String password) {
        Member member = memberReader.getMember(memberId);
        member.modifyPassword(password, passwordEncoder);
    }

    public void modifyEmail(Long memberId, String email) {
        Member member = memberReader.getMember(memberId);
        member.modifyEmail(email);
    }

    public void modifyPhoneNum(Long memberId, String phoneNum) {
        Member member = memberReader.getMember(memberId);
        member.modifyPhoneNum(phoneNum);
    }

    public void modifyAddress(Long memberId, AddressRequest request) {
        Member member = memberReader.getMember(memberId);
        Address address = new Address(request.getCity(), request.getStreet());
        member.modifyAddress(address);
    }
}

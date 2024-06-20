package com.example.ecommerce.app.member;

import com.example.ecommerce.api.member.request.*;
import com.example.ecommerce.domain.member.dto.*;
import com.example.ecommerce.domain.member.entity.member.*;
import com.example.ecommerce.domain.member.service.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class MemberModifyService {

    private final MemberReader memberReader;
    private final MemberMapper memberMapper;

    public void modifyProfile(Long memberId, ProfileRequest request) {
        Member member = memberReader.getMember(memberId);
        ProfileCommand command = memberMapper.commandOf(request);
        member.getProfile().modify(command.getEmail(), command.getPhoneNum());
    }
}

package com.example.ecommerce.domain.member.service;

import com.example.ecommerce.domain.member.dto.MemberCommand;
import com.example.ecommerce.domain.member.entity.member.Member;

public interface MemberFactory {
    Member make(MemberCommand.SignUp command);
}

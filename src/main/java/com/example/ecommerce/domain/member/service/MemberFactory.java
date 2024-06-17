package com.example.ecommerce.domain.member.service;

import com.example.ecommerce.domain.member.dto.SignUpCommand;
import com.example.ecommerce.domain.member.entity.member.Member;

public interface MemberFactory {
    Member make(SignUpCommand command);
}

package com.example.ecommerce.domain.member.service;

import com.example.ecommerce.domain.member.dto.MemberCommand;

public interface MemberValidator {
    void validate(MemberCommand.SignUp command);

    void validateUsername(String username);
}

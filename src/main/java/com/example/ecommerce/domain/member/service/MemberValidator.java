package com.example.ecommerce.domain.member.service;

import com.example.ecommerce.domain.member.dto.SignUpCommand;

public interface MemberValidator {
    void validate(SignUpCommand command);

    void validateUsername(String username);
}

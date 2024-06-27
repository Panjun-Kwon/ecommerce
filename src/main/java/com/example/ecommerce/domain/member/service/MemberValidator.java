package com.example.ecommerce.domain.member.service;

import com.example.ecommerce.domain.member.command.*;

public interface MemberValidator {
    void validateSignUp(SignUpCommand command);

    void validateUsername(String username);
}

package com.example.ecommerce.infra.member;

import com.example.ecommerce.common.exception.*;
import com.example.ecommerce.domain.member.command.*;
import com.example.ecommerce.domain.member.service.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;

@Component
@RequiredArgsConstructor
public class MemberValidatorImpl implements MemberValidator {

    private final MemberRepository memberRepository;

    @Override
    public void validateSignUp(SignUpCommand command) {
        validateUsername(command.getUsername());
    }

    @Override
    public void validateUsername(String username) {
        if (StringUtils.hasText(username) && memberRepository.existsByUsername(username)) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "USERNAME DUPLICATED");
        }
    }
}

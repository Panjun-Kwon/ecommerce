package com.example.ecommerce.infra.member;

import com.example.ecommerce.common.exception.CommonException;
import com.example.ecommerce.common.exception.ErrorCode;
import com.example.ecommerce.domain.member.dto.MemberCommand;
import com.example.ecommerce.domain.member.service.MemberRepository;
import com.example.ecommerce.domain.member.service.MemberValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class MemberValidatorImpl implements MemberValidator {

    private final MemberRepository memberRepository;

    @Override
    public void validate(MemberCommand.SignUp command) {
        validateUsername(command.getUsername());
    }

    @Override
    public void validateUsername(String username) {
        if (!StringUtils.hasText(username)) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "USERNAME IS REQUIRED");
        }

        if (StringUtils.hasText(username) && memberRepository.existsByUsername(username)) {
            throw new CommonException(ErrorCode.INVALID_PARAMETER, "USERNAME DUPLICATED");
        }
    }
}

package com.example.ecommerce.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    BUSINESS_FAIL("비즈니스 실패"),
    CLIENT_ERROR("클라이언트 에러"),
    SERVER_ERROR("서버 에러"),
    INVALID_PARAMETER("유효하지 않은 파라미터");

    private final String message;
}

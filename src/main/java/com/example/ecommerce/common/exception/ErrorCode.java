package com.example.ecommerce.common.exception;

import lombok.*;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {
    BUSINESS_FAIL("비즈니스 실패"),
    CLIENT_ERROR("클라이언트 에러"),
    SERVER_ERROR("서버 에러"),

    MULTIPLE_EXCEPTIONS("다중 오류 발생"),

    INVALID_PARAMETER("유효하지 않은 파라미터"),
    INVALID_TOKEN("유효하지 않은 토큰"),
    INVALID_AUTHENTICATION("유효하지 않은 인증"),
    INVALID_ROLE("유효하지 않은 권한"),

    NOT_FOUND_ENTITY("엔티티를 찾을 수 없음"),
    OUT_OF_STOCK("상품 재고 부족"),
    ;

    private final String message;
}

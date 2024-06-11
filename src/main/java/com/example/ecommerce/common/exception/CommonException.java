package com.example.ecommerce.common.exception;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {

    private ErrorCode errorCode;

    public CommonException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public CommonException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public CommonException(ErrorCode errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}

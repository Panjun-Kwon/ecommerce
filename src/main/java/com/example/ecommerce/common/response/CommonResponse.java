package com.example.ecommerce.common.response;

import com.example.ecommerce.common.exception.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {
    private Result result;
    private String message;
    private T data;
    private String errorCode;

    public enum Result {
        SUCCESS, FAIL, ERROR
    }

    public static <T> CommonResponse<T> success(String message, T data) {
        return CommonResponse.<T>builder()
                .result(Result.SUCCESS)
                .message(message)
                .data(data)
                .build();
    }

    public static CommonResponse fail(ErrorCode errorCode) {
        return CommonResponse.builder()
                .result(Result.FAIL)
                .message(errorCode.getMessage())
                .errorCode(errorCode.name())
                .build();
    }

    public static CommonResponse fail(String message, ErrorCode errorCode) {
        return CommonResponse.builder()
                .result(Result.FAIL)
                .message(message)
                .errorCode(errorCode.name())
                .build();
    }

    public static CommonResponse error(ErrorCode errorCode) {
        return CommonResponse.builder()
                .result(Result.ERROR)
                .message(errorCode.getMessage())
                .errorCode(errorCode.name())
                .build();
    }

    public static CommonResponse error(String message, ErrorCode errorCode) {
        return CommonResponse.builder()
                .result(Result.ERROR)
                .message(message)
                .errorCode(errorCode.name())
                .build();
    }
}

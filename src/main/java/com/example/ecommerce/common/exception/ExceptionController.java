package com.example.ecommerce.common.exception;

import com.example.ecommerce.common.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(CommonException.class)
    @ResponseStatus(HttpStatus.OK)
    public static CommonResponse commonException(CommonException e) {
        return CommonResponse.fail(e.getMessage(), e.getErrorCode());
    }

    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.OK)
    public static List<CommonResponse> bizException(BizException e) {
        List<CommonResponse> errors = new ArrayList<>();
        if (!e.getExceptions().isEmpty()) {
            e.getExceptions().stream()
                    .forEach(error -> {
                        String message = String.format("%s",
                                error.getMessage());
                        errors.add(CommonResponse.fail(message, ErrorCode.MULTIPLE_EXCEPTIONS));
                    });
        }

        return errors;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public static List<CommonResponse> clientError(MethodArgumentNotValidException e) {
        List<CommonResponse> errors = new ArrayList<>();
        if (e.hasFieldErrors()) {
            e.getFieldErrors().stream()
                    .forEach(error -> {
                        String message = String.format("%s = %s (%s)",
                                error.getField(), error.getRejectedValue(), error.getDefaultMessage());
                        errors.add(CommonResponse.error(message, ErrorCode.INVALID_PARAMETER));
                    });
        } else {
            errors.add(CommonResponse.error(ErrorCode.INVALID_PARAMETER));
        }
        return errors;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public static CommonResponse serverError(Exception e) {
        return CommonResponse.error(e.getMessage(), ErrorCode.SERVER_ERROR);
    }
}

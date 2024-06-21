package com.example.ecommerce.common.exception;

import com.example.ecommerce.common.response.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler(CommonException.class)
    @ResponseStatus(HttpStatus.OK)
    public static CommonResponse commonException(CommonException e) {
        return CommonResponse.fail(e.getMessage(), e.getErrorCode());
    }

    @ExceptionHandler(MultiException.class)
    @ResponseStatus(HttpStatus.OK)
    public static List<CommonResponse> bizException(MultiException e) {
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
        log.warn("{}", e.getStackTrace());
        return CommonResponse.error(e.getMessage(), ErrorCode.SERVER_ERROR);
    }
}

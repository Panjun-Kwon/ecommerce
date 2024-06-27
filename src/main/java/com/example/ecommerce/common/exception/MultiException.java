package com.example.ecommerce.common.exception;

import lombok.*;

import java.util.*;

@Getter
public class MultiException extends RuntimeException {

    private final List<CommonException> exceptions = new ArrayList<>();

    public MultiException() {
        super(ErrorCode.MULTIPLE_EXCEPTIONS.getMessage());
    }

    public void addException(CommonException e) {
        exceptions.add(e);
    }
}

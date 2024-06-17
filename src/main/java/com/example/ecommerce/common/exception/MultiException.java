package com.example.ecommerce.common.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MultiException extends RuntimeException {

    private final List<CommonException> exceptions = new ArrayList<>();

    public MultiException() {
        super("Multiple exceptions occurred");
    }

    public void addException(CommonException e) {
        exceptions.add(e);
    }
}

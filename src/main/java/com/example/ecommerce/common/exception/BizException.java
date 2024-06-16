package com.example.ecommerce.common.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BizException extends RuntimeException {

    private final List<CommonException> exceptions = new ArrayList<>();

    public BizException() {
        super("Multiple exceptions occurred");
    }

    public void addException(CommonException e) {
        exceptions.add(e);
    }

    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder();
        for (CommonException e : exceptions) {
            message.append("\n - ").append(e.getMessage());
        }
        return message.toString();
    }
}

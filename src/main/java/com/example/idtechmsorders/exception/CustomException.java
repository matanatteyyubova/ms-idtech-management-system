package com.example.idtechmsorders.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private final String message;
    @Getter
    private final String field;
    @Getter
    private final HttpStatus status;

    @Override
    public String getMessage() {
        return message;
    }

    public CustomException(String message,
                           String field,
                           HttpStatus status) {
        this.message = message;
        this.field = field;
        this.status = status;
    }
}

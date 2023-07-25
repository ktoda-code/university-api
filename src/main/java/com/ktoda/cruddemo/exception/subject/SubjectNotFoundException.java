package com.ktoda.cruddemo.exception.subject;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class SubjectNotFoundException extends SubjectRequestException {
    @Getter
    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public SubjectNotFoundException(String message) {
        super(message);
    }

    public SubjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

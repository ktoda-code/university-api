package com.ktoda.cruddemo.exception.subject;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class SubjectAlreadyExistsException extends SubjectRequestException {
    @Getter
    private final HttpStatus status = HttpStatus.CONFLICT;

    public SubjectAlreadyExistsException(String message) {
        super(message);
    }

    public SubjectAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

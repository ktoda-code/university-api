package com.ktoda.cruddemo.exception.student;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class StudentRequestAlreadyExistsException extends StudentRequestException {
    @Getter
    private final HttpStatus status = HttpStatus.CONFLICT;

    public StudentRequestAlreadyExistsException(String message) {
        super(message);
    }

    public StudentRequestAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

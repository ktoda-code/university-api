package com.ktoda.cruddemo.exception.student;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class StudentAlreadyExistsException extends StudentRequestException {
    @Getter
    private final HttpStatus status = HttpStatus.CONFLICT;

    public StudentAlreadyExistsException(String message) {
        super(message);
    }

    public StudentAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

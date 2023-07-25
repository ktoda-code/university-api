package com.ktoda.cruddemo.exception.student;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends StudentRequestException {
    @Getter
    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

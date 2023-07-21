package com.ktoda.cruddemo.exception.student;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class StudentRequestNotFoundException extends StudentRequestException {
    @Getter
    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public StudentRequestNotFoundException(String message) {
        super(message);
    }

    public StudentRequestNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

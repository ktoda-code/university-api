package com.ktoda.cruddemo.exception.teacher;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class TeacherNotFoundException extends TeacherRequestException {
    @Getter
    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public TeacherNotFoundException(String message) {
        super(message);
    }

    public TeacherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.ktoda.cruddemo.exception.teacher;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class TeacherAlreadyExistsException extends TeacherRequestException {
    @Getter
    private final HttpStatus status = HttpStatus.CONFLICT;

    public TeacherAlreadyExistsException(String message) {
        super(message);
    }

    public TeacherAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

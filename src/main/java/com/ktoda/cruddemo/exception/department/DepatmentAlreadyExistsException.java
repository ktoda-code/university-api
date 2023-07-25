package com.ktoda.cruddemo.exception.department;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class DepatmentAlreadyExistsException extends DepartmentRequestException {
    @Getter
    private final HttpStatus status = HttpStatus.CONFLICT;

    public DepatmentAlreadyExistsException(String message) {
        super(message);
    }

    public DepatmentAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

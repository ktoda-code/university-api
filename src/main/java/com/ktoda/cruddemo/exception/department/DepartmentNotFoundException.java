package com.ktoda.cruddemo.exception.department;

import com.ktoda.cruddemo.exception.student.StudentRequestException;
import lombok.Getter;
import org.springframework.http.HttpStatus;

public class DepartmentNotFoundException extends DepartmentRequestException {
    @Getter
    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public DepartmentNotFoundException(String message) {
        super(message);
    }

    public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

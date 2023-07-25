package com.ktoda.cruddemo.exception.department;

public class DepartmentRequestException extends RuntimeException {
    public DepartmentRequestException(String message) {
        super(message);
    }

    public DepartmentRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}

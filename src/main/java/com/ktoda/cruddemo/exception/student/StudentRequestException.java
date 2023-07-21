package com.ktoda.cruddemo.exception.student;

public class StudentRequestException extends RuntimeException {

    public StudentRequestException(String message) {
        super(message);
    }

    public StudentRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}

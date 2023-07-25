package com.ktoda.cruddemo.exception.teacher;

public class TeacherRequestException extends RuntimeException {
    public TeacherRequestException(String message) {
        super(message);
    }

    public TeacherRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}

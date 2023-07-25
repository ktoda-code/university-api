package com.ktoda.cruddemo.exception.subject;

public class SubjectRequestException extends RuntimeException {
    public SubjectRequestException(String message) {
        super(message);
    }

    public SubjectRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}

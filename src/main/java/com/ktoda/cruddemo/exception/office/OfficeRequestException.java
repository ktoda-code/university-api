package com.ktoda.cruddemo.exception.office;

public class OfficeRequestException extends RuntimeException {
    public OfficeRequestException(String message) {
        super(message);
    }

    public OfficeRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}

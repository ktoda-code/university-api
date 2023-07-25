package com.ktoda.cruddemo.exception.office;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class OfficeNotFoundException extends OfficeRequestException {
    @Getter
    private final HttpStatus status = HttpStatus.NOT_FOUND;

    public OfficeNotFoundException(String message) {
        super(message);
    }

    public OfficeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

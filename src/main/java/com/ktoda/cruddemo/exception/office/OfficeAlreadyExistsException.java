package com.ktoda.cruddemo.exception.office;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class OfficeAlreadyExistsException extends OfficeRequestException {
    @Getter
    private final HttpStatus status = HttpStatus.CONFLICT;
    
    public OfficeAlreadyExistsException(String message) {
        super(message);
    }

    public OfficeAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.ktoda.cruddemo.exception.office;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class OfficeExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleOfficeRequestNotFound(OfficeNotFoundException e) {
        OfficeException officeException = new OfficeException(
                e.getMessage(),
                e.getStatus(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(officeException, e.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleOfficeRequestAlreadyExists(OfficeAlreadyExistsException e) {
        OfficeException officeException = new OfficeException(
                e.getMessage(),
                e.getStatus(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(officeException, e.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleOfficeBadRequest(Exception e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        OfficeException officeException = new OfficeException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(officeException, badRequest);
    }
}

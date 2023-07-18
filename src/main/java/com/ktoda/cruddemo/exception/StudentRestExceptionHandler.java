package com.ktoda.cruddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleStudentRequestNotFound(StudentRequestException e) {
        // 1. Create payload containing exception details
        HttpStatus notFoundRequest = HttpStatus.NOT_FOUND;
        StudentException studentException = new StudentException(
                e.getMessage(),
                notFoundRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        // 2. Return response entity
        return new ResponseEntity<>(studentException, notFoundRequest);
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleStudentRequestBadRequest(Exception e) {
        // 1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        StudentException studentException = new StudentException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        // 2. Return response entity
        return new ResponseEntity<>(studentException, badRequest);
    }
}

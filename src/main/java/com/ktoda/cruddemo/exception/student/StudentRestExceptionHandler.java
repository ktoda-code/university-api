package com.ktoda.cruddemo.exception.student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleStudentRequestNotFound(StudentRequestNotFoundException e) {
        // 1. Create payload containing exception details
        StudentException studentException = new StudentException(
                e.getMessage(),
                e.getStatus(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        // 2. Return response entity
        return new ResponseEntity<>(studentException, e.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleStudentRequestAlreadyExists(StudentRequestAlreadyExistsException e) {
        // 1. Create payload containing exception details
        StudentException studentException = new StudentException(
                e.getMessage(),
                e.getStatus(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        // 2. Return response entity
        return new ResponseEntity<>(studentException, e.getStatus());
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

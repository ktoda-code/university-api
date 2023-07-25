package com.ktoda.cruddemo.exception.department;


import com.ktoda.cruddemo.exception.student.StudentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class DepartmentExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleDepartmentRequestNotFound(DepartmentNotFoundException e) {
        DepartmentException departmentException = new DepartmentException(
                e.getMessage(),
                e.getStatus(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(departmentException, e.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleDepartmentRequestAlreadyExists(DepatmentAlreadyExistsException e) {
        DepartmentException departmentException = new DepartmentException(
                e.getMessage(),
                e.getStatus(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(departmentException, e.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleDepartmentRequestBadRequest(Exception e) {
        // 1. Create payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        DepartmentException exception = new DepartmentException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        // 2. Return response entity
        return new ResponseEntity<>(exception, badRequest);
    }
}

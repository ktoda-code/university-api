package com.ktoda.cruddemo.exception.teacher;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class TeacherExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleTeacherNotFound(TeacherNotFoundException e) {
        TeacherException teacherException = new TeacherException(
                e.getMessage(),
                e.getStatus(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(teacherException, e.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleTeacherAlreadyExists(TeacherAlreadyExistsException e) {
        TeacherException teacherException = new TeacherException(
                e.getMessage(),
                e.getStatus(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(teacherException, e.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleTeacherBadRequest(Exception e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        TeacherException teacherException = new TeacherException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(teacherException, badRequest);
    }

}

package com.ktoda.cruddemo.exception.subject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class SubjectExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Object> handleSubjectNotFound(SubjectNotFoundException e) {
        SubjectException subjectException = new SubjectException(
                e.getMessage(),
                e.getStatus(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(subjectException, e.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleSubjectAlreadyExists(SubjectAlreadyExistsException e) {
        SubjectException subjectException = new SubjectException(
                e.getMessage(),
                e.getStatus(),
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(subjectException, e.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<Object> handleSubjectBadRequest(Exception e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        SubjectException subjectException = new SubjectException(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(subjectException, badRequest);
    }
}

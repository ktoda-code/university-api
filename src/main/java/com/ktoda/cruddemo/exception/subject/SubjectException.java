package com.ktoda.cruddemo.exception.subject;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record SubjectException(String message, HttpStatus status, ZonedDateTime timeStamp) {
}

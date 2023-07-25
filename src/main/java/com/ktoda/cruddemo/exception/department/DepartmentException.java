package com.ktoda.cruddemo.exception.department;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record DepartmentException(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
}

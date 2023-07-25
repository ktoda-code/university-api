package com.ktoda.cruddemo.exception.office;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record OfficeException(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
}

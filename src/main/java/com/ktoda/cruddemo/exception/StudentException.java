package com.ktoda.cruddemo.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record StudentException(String message, HttpStatus httpStatus, ZonedDateTime timeStamp) {
}

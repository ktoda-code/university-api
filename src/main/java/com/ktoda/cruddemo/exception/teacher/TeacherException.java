package com.ktoda.cruddemo.exception.teacher;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record TeacherException(String message, HttpStatus status, ZonedDateTime timeStamp) {
}

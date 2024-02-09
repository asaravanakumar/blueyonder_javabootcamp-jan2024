package com.labs.spring.rest.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GenericExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        String msg = "No matching greetings found";
        return ResponseEntity.internalServerError().body(msg);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        String msg = "ERROR: " + e.getMessage();
        return ResponseEntity.internalServerError().body(msg);
    }
}

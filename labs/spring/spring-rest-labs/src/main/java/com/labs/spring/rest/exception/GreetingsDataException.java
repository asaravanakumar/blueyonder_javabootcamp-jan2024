package com.labs.spring.rest.exception;

public class GreetingsDataException extends Exception {
    public GreetingsDataException() {
    }

    public GreetingsDataException(String message) {
        super(message);
    }

    public GreetingsDataException(String message, Throwable cause) {
        super(message, cause);
    }
}

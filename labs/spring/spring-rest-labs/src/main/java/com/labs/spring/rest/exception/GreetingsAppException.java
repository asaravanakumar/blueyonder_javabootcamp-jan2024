package com.labs.spring.rest.exception;

public class GreetingsAppException extends Exception {
    public GreetingsAppException() {
    }

    public GreetingsAppException(String message) {
        super(message);
    }

    public GreetingsAppException(String message, Throwable cause) {
        super(message, cause);
    }

}

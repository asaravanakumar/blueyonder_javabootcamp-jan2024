package com.labs.sboot.rest.exception;

public class NoGreetingsFoundException extends Exception {

    public NoGreetingsFoundException() {
    }

    public NoGreetingsFoundException(String message) {
        super(message);
    }

    public NoGreetingsFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

package org.example.exception;

public class StopListNotFoundException extends RuntimeException {
    public StopListNotFoundException(String message) {
        super(message);
    }
}

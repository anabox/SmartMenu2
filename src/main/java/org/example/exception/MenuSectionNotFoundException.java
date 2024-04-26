package org.example.exception;

public class MenuSectionNotFoundException extends RuntimeException {
    public MenuSectionNotFoundException(String message) {
        super(message);
    }
}

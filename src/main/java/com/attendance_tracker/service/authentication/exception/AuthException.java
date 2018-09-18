package com.attendance_tracker.service.authentication.exception;

public class AuthException extends Exception {

    public AuthException() {
        super();
    }

    public AuthException(String msg) {
        this(msg, null);
    }

    public AuthException(Exception cause) {
        this(null, cause);
    }

    public AuthException(String message, Throwable cause) {
        super(message, cause);
    }
}

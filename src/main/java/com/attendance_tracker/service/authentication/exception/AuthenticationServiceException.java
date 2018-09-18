package com.attendance_tracker.service.authentication.exception;

public class AuthenticationServiceException  extends Exception {

    public AuthenticationServiceException() {
        super();
    }

    public AuthenticationServiceException(String msg) {
        this(msg, null);
    }

    public AuthenticationServiceException(Exception cause) {
        this(null, cause);
    }

    public AuthenticationServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

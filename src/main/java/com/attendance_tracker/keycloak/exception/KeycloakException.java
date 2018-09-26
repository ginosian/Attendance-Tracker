package com.attendance_tracker.keycloak.exception;

import com.attendance_tracker.exception.APIError;
import com.attendance_tracker.exception.APIException;

public class KeycloakException extends APIException {

    public KeycloakException(int responseStatusCode, String message, long applicationErrorCode) {
        super(responseStatusCode, message, applicationErrorCode);
    }

    public KeycloakException(APIError error, Exception cause) {
        super(error, cause);
    }

    public KeycloakException(APIError error, String message, Exception cause) {
        super(error, message, cause);
    }

    public KeycloakException(APIError error, String message, int responseStatusCode) {
        super(error, message, responseStatusCode);
    }

    public KeycloakException(APIError error, String message, int responseStatusCode, Exception cause) {
        super(error, message, responseStatusCode, cause);
    }
}

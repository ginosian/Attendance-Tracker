package com.attendance_tracker.exception;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.WebApplicationException;

@JsonIgnoreProperties({"response", "cause", "stackTrace", "responseStatusCode",
        "localizedMessage", "suppressed", "suppressedExceptions", "detailMessage"})
public class APIException extends WebApplicationException {

    @JsonProperty("status")
    private final APIError error;

    @JsonProperty("httpStatus")
    private final int responseStatusCode;

    @JsonProperty("appErrorCode")
    private final long applicationErrorCode;

    @JsonProperty("message")
    private final String message;

    public APIException(int responseStatusCode, String message, long applicationErrorCode) {
        this.error = null;
        this.message = message;
        this.responseStatusCode = responseStatusCode;
        this.applicationErrorCode = applicationErrorCode;
    }

    public APIException(APIError error, Exception cause) {
        this(error, error.getDefaultMessage(), cause);
    }

    public APIException(APIError error, String message, Exception cause) {
        this(error, message, error.getResponseHttpStatus().getStatusCode(), cause);
    }

    public APIException(@JsonProperty("status") APIError error,
                              @JsonProperty("message") String message,
                              @JsonProperty("httpStatus") int responseStatusCode) {
        super(message, error.getResponseHttpStatus());
        this.applicationErrorCode = error.getErrorCode();
        this.message = message == null ? error.getDefaultMessage() == null ? error.toString() : error.getDefaultMessage() : message;
        this.responseStatusCode = responseStatusCode;
        this.error = error;
    }

    public APIException(APIError error, String message, int responseStatusCode, Exception cause) {
        super(message, cause, error.getResponseHttpStatus());
        this.applicationErrorCode = error.getErrorCode();
        this.message = message == null ? error.getDefaultMessage() == null ? error.toString() : error.getDefaultMessage() : message;
        this.responseStatusCode = responseStatusCode;
        this.error = error;
    }

    public APIError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getResponseStatusCode() {
        return responseStatusCode;
    }

    public long getApplicationErrorCode() {
        return applicationErrorCode;
    }
}

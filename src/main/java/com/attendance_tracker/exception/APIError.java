package com.attendance_tracker.exception;

import javax.ws.rs.core.Response;

public interface APIError {

    String getDefaultMessage();

    Response.Status getResponseHttpStatus();

    long getErrorCode();

    Class<? extends APIException> getExceptionClass();
}

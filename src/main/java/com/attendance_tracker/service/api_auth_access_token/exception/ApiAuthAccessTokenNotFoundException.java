package com.attendance_tracker.service.api_auth_access_token.exception;

public class ApiAuthAccessTokenNotFoundException extends Exception{

    private final String token;

    public ApiAuthAccessTokenNotFoundException(final String token) {
        super(String.format("Api access token with token (%1$s) cannot be found.", token));
        this.token = token;
    }

    public String getPoiId() {
        return token;
    }
}

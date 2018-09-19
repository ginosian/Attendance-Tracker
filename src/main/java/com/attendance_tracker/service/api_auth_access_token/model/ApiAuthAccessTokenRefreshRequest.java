package com.attendance_tracker.service.api_auth_access_token.model;

import com.attendance_tracker.entity.ApiAuthAccessToken;

public class ApiAuthAccessTokenRefreshRequest {

    private ApiAuthAccessToken token;

    public ApiAuthAccessTokenRefreshRequest() {
    }

    public ApiAuthAccessTokenRefreshRequest(ApiAuthAccessToken token) {
        this.token = token;
    }

    public ApiAuthAccessToken getToken() {
        return token;
    }

    public void setToken(ApiAuthAccessToken token) {
        this.token = token;
    }
}

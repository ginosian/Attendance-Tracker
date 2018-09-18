package com.attendance_tracker.service.api_auth_access_token.model;

import java.util.Date;

public class ApiAuthAccessTokenRefreshRequest {

    private String token;

    private Date created;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

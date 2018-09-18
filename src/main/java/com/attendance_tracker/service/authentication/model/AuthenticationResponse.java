package com.attendance_tracker.service.authentication.model;

import java.time.LocalDateTime;

public class AuthenticationResponse {

    private String userId;
    private String token;
    private LocalDateTime tokenExpirationDate;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String userId, String token, LocalDateTime tokenExpirationDate) {
        this.userId = userId;
        this.token = token;
        this.tokenExpirationDate = tokenExpirationDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getTokenExpirationDate() {
        return tokenExpirationDate;
    }

    public void setTokenExpirationDate(LocalDateTime tokenExpirationDate) {
        this.tokenExpirationDate = tokenExpirationDate;
    }
}

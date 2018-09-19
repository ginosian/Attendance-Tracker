package com.attendance_tracker.facade.authentication.model;

public class AuthenticationRequest{

    private String username;
    private String plainPassword;
    private boolean rememberMe;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String username, String plainPassword, boolean rememberMe) {
        this.username = username;
        this.plainPassword = plainPassword;
        this.rememberMe = rememberMe;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlainPassword() {
        return plainPassword;
    }

    public void setPlainPassword(String plainPassword) {
        this.plainPassword = plainPassword;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }
}

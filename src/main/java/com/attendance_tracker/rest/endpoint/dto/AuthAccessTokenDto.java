package com.attendance_tracker.rest.endpoint.dto;

public class AuthAccessTokenDto {

    private String token;
    private AuthorityDto principal;

    public AuthAccessTokenDto(String token, AuthorityDto principal) {
        this.token = token;
        this.principal = principal;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthorityDto getPrincipal() {
        return principal;
    }

    public void setPrincipal(AuthorityDto principal) {
        this.principal = principal;
    }
}

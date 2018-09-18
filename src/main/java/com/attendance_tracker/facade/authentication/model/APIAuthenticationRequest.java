package com.attendance_tracker.facade.authentication.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class APIAuthenticationRequest implements Authentication {

    private final AuthenticationRequest authenticationRequest;

    public APIAuthenticationRequest(AuthenticationRequest authenticationRequest) {
        this.authenticationRequest = authenticationRequest;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return authenticationRequest;
    }

    @Override
    public Object getDetails() {
        return authenticationRequest;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }
}

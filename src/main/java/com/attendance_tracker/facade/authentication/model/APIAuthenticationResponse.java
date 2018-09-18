package com.attendance_tracker.facade.authentication.model;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class APIAuthenticationResponse implements Authentication {

    private final AuthenticationResponse authenticationResponse;

    public APIAuthenticationResponse(AuthenticationResponse authenticationResponse) {
        this.authenticationResponse = authenticationResponse;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return authenticationResponse.getApiUserDetail().getUsername();
    }

    @Override
    public Object getDetails() {
        return authenticationResponse;
    }

    @Override
    public Object getPrincipal() {
        return authenticationResponse.getApiUserDetail();
    }

    @Override
    public boolean isAuthenticated() {
        return !StringUtils.isEmpty(authenticationResponse.getToken());
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return authenticationResponse.getApiUserDetail().getUsername();
    }
}

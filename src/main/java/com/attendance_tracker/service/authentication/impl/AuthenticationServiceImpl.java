package com.attendance_tracker.service.authentication.impl;


import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.service.authentication.AuthenticationService;
import com.attendance_tracker.service.authentication.exception.AuthenticationServiceException;
import com.attendance_tracker.service.authentication.model.AuthenticationRequest;
import com.attendance_tracker.service.authentication.model.AuthenticationResponse;
import com.attendance_tracker.service.authentication.model.TokenAuthenticationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Value("#{'${authenticationService.masterApiUserDetail.passwordHash}' ?: null}")
    private String masterApiUserDetailPasswordHash;

    @Override
    public AuthenticationResponse authenticateByCredentials(AuthenticationRequest authRequest) throws AuthenticationServiceException {
        return null;
    }

    @Override
    public AuthenticationResponse authenticateByRememberMeToken(TokenAuthenticationRequest authRequest) throws AuthenticationServiceException {
        return null;
    }

    @Override
    public ApiAuthAccessToken authenticateByApiAccessToken(String token) throws AuthenticationServiceException {
        return null;
    }
}

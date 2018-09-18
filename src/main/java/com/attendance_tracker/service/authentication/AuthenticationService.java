package com.attendance_tracker.service.authentication;

import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.service.authentication.exception.AuthenticationServiceException;
import com.attendance_tracker.service.authentication.model.AuthenticationRequest;
import com.attendance_tracker.service.authentication.model.AuthenticationResponse;
import com.attendance_tracker.service.authentication.model.TokenAuthenticationRequest;

public interface AuthenticationService {

    AuthenticationResponse authenticateByCredentials(AuthenticationRequest authRequest) throws AuthenticationServiceException;

    AuthenticationResponse authenticateByRememberMeToken(TokenAuthenticationRequest authRequest) throws AuthenticationServiceException;

    ApiAuthAccessToken authenticateByApiAccessToken(String token) throws AuthenticationServiceException;
}

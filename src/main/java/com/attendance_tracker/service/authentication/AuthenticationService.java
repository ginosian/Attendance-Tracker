package com.attendance_tracker.service.authentication;

import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.service.authentication.exception.AuthException;
import com.attendance_tracker.service.authentication.model.AuthenticationRequest;
import com.attendance_tracker.service.authentication.model.AuthenticationResponse;
import com.attendance_tracker.service.authentication.model.TokenAuthenticationRequest;

public interface AuthenticationService {

    AuthenticationResponse authenticateByCredentials(AuthenticationRequest request) throws AuthException;

    AuthenticationResponse authenticateByRememberMeToken(TokenAuthenticationRequest request) throws AuthException;

    ApiAuthAccessToken authenticateByApiAccessToken(String token) throws AuthException;
}

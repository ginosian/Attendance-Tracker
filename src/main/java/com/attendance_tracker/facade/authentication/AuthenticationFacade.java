package com.attendance_tracker.facade.authentication;

import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.facade.authentication.exception.AuthException;
import com.attendance_tracker.facade.authentication.model.AuthenticationRequest;
import com.attendance_tracker.facade.authentication.model.AuthenticationResponse;
import com.attendance_tracker.facade.authentication.model.TokenAuthenticationRequest;

public interface AuthenticationFacade {

    AuthenticationResponse authenticateByCredentials(AuthenticationRequest request) throws AuthException;

    AuthenticationResponse authenticateByRememberMeToken(TokenAuthenticationRequest request) throws AuthException;

    ApiAuthAccessToken authenticateByApiAccessToken(String token) throws AuthException;
}

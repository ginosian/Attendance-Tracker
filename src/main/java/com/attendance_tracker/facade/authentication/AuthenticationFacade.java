package com.attendance_tracker.facade.authentication;

import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.facade.authentication.exception.AuthException;
import com.attendance_tracker.facade.authentication.model.AuthenticationRequest;
import com.attendance_tracker.facade.authentication.model.AuthenticationResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public interface AuthenticationFacade  extends AuthenticationManager {

    AuthenticationResponse authenticateByCredentials(AuthenticationRequest request);

    ApiAuthAccessToken authenticateByApiAccessToken(String token) throws AuthException;

    Authentication authenticate(Authentication authentication) throws AuthenticationException;
}

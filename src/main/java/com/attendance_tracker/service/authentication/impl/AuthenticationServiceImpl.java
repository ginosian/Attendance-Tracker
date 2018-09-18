package com.attendance_tracker.service.authentication.impl;


import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.misc.TokenType;
import com.attendance_tracker.service.api_auth_access_token.ApiAuthAccessTokenService;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.authentication.AuthenticationService;
import com.attendance_tracker.service.authentication.PasswordHashHelperComponent;
import com.attendance_tracker.service.authentication.exception.AuthException;
import com.attendance_tracker.service.authentication.exception.AuthenticationException;
import com.attendance_tracker.service.authentication.exception.AuthorizationException;
import com.attendance_tracker.service.authentication.model.AuthenticationRequest;
import com.attendance_tracker.service.authentication.model.AuthenticationResponse;
import com.attendance_tracker.service.authentication.model.TokenAuthenticationRequest;
import com.attendance_tracker.service.notification.NotificationService;
import com.attendance_tracker.service.user_detail.ApiUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    private ApiUserDetailService apiUserDetailService;

    @Autowired
    private PasswordHashHelperComponent passwordHashHelperComponent;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private ApiAuthAccessTokenService apiAuthAccessTokenService;

    @Value("#{'${authenticationService.masterApiUserDetail.passwordHash}' ?: null}")
    private String masterApiUserDetailPasswordHash;

    @Override
    public AuthenticationResponse authenticateByCredentials(AuthenticationRequest request) throws AuthException {
        notNull(request, "authenticationRequest.request cannot be null.");
        final String username = request.getUsername();
        final String plainPassword = request.getPlainPassword();
        notNull(username, "authenticationRequest.request.username cannot be null.");
        notNull(plainPassword, "authenticationRequest.request.plainPassword cannot be null.");

        logger.debug("Attempting authentication with username:'{}'...", username);
        final APIUserDetail userDetail = apiUserDetailService.loadUserByUsername(username);
        logger.trace("Found authority:'{}' by username.", userDetail.getId());

        final String userId = userDetail.getUser().getId();

        if(!userDetail.isApproved()){
            notificationService.requestEmailVerification();
            logger.debug("Authentication failed for for user:'{}' as email:'{}' is not verified.", userId, username);
            throw new AuthorizationException();
        }

        logger.debug("Attempting authentication with password for user:'{}'...", userId);
        if(!passwordHashHelperComponent.isPasswordCorrect(plainPassword)){
            logger.debug("Password validation failed for user:'{}'.", userId);
            throw new AuthenticationException();
        }
        logger.trace("Password validation passed for user:'{}'.", userId);

        final ApiAuthAccessTokenCreationRequest apiAuthAccessTokenCreationRequest = new ApiAuthAccessTokenCreationRequest();
        apiAuthAccessTokenCreationRequest.setUserDetail(userDetail);
        apiAuthAccessTokenCreationRequest.setDescription(request.getDescription());
        final boolean isRememberMe = request.isRememberMe();
        apiAuthAccessTokenCreationRequest.setTokenType(isRememberMe ? TokenType.LOGIN_REMEMBER_ME : TokenType.LOGIN);

        logger.debug("Creating apiAuthAccessToken for user:'{}'...", userId);
        final ApiAuthAccessToken apiAuthAccessToken = apiAuthAccessTokenService.createApiAccessToken(apiAuthAccessTokenCreationRequest);
        logger.trace("ApiAuthAccessToken:'{}' is created for user:'{}'.", apiAuthAccessToken.getToken(), userId);

        return new AuthenticationResponse(userId, apiAuthAccessToken.getToken(),apiAuthAccessToken.getExpires());
    }

    @Override
    public AuthenticationResponse authenticateByRememberMeToken(TokenAuthenticationRequest request) throws AuthException {
        return null;
    }

    @Override
    public ApiAuthAccessToken authenticateByApiAccessToken(String token) throws AuthException {
        return null;
    }
}

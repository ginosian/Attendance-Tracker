package com.attendance_tracker.facade.authentication.impl;


import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.facade.authentication.AuthenticationFacade;
import com.attendance_tracker.facade.authentication.exception.AuthException;
import com.attendance_tracker.facade.authentication.model.APIAuthenticationResponse;
import com.attendance_tracker.facade.authentication.model.AuthenticationRequest;
import com.attendance_tracker.facade.authentication.model.AuthenticationResponse;
import com.attendance_tracker.facade.strategy.UserCredentialValidationStrategy;
import com.attendance_tracker.misc.TokenType;
import com.attendance_tracker.service.api_auth_access_token.ApiAuthAccessTokenService;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenRefreshRequest;
import com.attendance_tracker.service.user_detail.ApiUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Date;

import static org.springframework.util.Assert.notNull;

@Service
public class AuthenticationFacadeImpl implements AuthenticationFacade {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFacadeImpl.class);

    @Autowired
    private ApiUserDetailService apiUserDetailService;

    @Autowired
    private ApiAuthAccessTokenService apiAuthAccessTokenService;

    @Autowired
    private UserCredentialValidationStrategy userCredentialValidationStrategy;

    @Value("#{'${authenticationService.masterApiUserDetail.passwordHash}' ?: null}")
    private String masterApiUserDetailPasswordHash;

    @Override
    public AuthenticationResponse authenticateByCredentials(final AuthenticationRequest request){
        notNull(request, "authenticationRequest.request cannot be null.");
        final String username = request.getUsername();
        final String plainPassword = request.getPlainPassword();
        notNull(username, "authenticationRequest.request.username cannot be null.");
        notNull(plainPassword, "authenticationRequest.request.plainPassword cannot be null.");

        logger.debug("Attempting authentication with username:'{}'...", username);
        final APIUserDetail userDetail = apiUserDetailService.loadUserByUsername(username);
        logger.trace("Found authority:'{}' by username.", userDetail.getId());

        final String userId = userDetail.getUser().getId();

        userCredentialValidationStrategy.validateForAuthentication(userDetail);

        final ApiAuthAccessToken existingToken = apiAuthAccessTokenService.findByUserDetail(userDetail.getId()).orElse(null);


        if(existingToken == null){
            final ApiAuthAccessTokenCreationRequest apiAuthAccessTokenCreationRequest = create(userDetail, request.isRememberMe());

            logger.debug("Creating apiAuthAccessToken for user:'{}'...", userId);
            final ApiAuthAccessToken apiAuthAccessToken = apiAuthAccessTokenService.createApiAccessToken(apiAuthAccessTokenCreationRequest);
            logger.trace("ApiAuthAccessToken:'{}' is created for user:'{}'.", apiAuthAccessToken.getToken(), userId);
            return new AuthenticationResponse(userDetail, apiAuthAccessToken.getToken());
        } else {
            final ApiAuthAccessTokenRefreshRequest apiAuthAccessTokenRefreshRequest = new ApiAuthAccessTokenRefreshRequest(existingToken);
            logger.debug("Refreshing apiAuthAccessToken for user:'{}'...", userId);
            final ApiAuthAccessToken apiAuthAccessToken = apiAuthAccessTokenService.updateApiAccessToken(apiAuthAccessTokenRefreshRequest);
            logger.trace("ApiAuthAccessToken:'{}' is refreshed for user:'{}'.", apiAuthAccessToken.getToken(), userId);
            return new AuthenticationResponse(userDetail, apiAuthAccessToken.getToken());
        }
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return new APIAuthenticationResponse(authenticateByCredentials((AuthenticationRequest)authentication.getDetails()));
    }

    @Override
    public ApiAuthAccessToken authenticateByApiAccessToken(final String token) throws AuthException {
        final ApiAuthAccessToken existingToken = apiAuthAccessTokenService.findByApiAccessToken(token).orElse(null);
        if(existingToken == null){
            throw new AuthenticationCredentialsNotFoundException("Api Access Token doesn't exist.");
        }
        return existingToken;
    }

    private ApiAuthAccessTokenCreationRequest create(final APIUserDetail userDetail, final boolean isRememberMe){
        final ApiAuthAccessTokenCreationRequest apiAuthAccessTokenCreationRequest = new ApiAuthAccessTokenCreationRequest();
        apiAuthAccessTokenCreationRequest.setUserDetail(userDetail);
        apiAuthAccessTokenCreationRequest.setTokenType(isRememberMe ? TokenType.LOGIN_REMEMBER_ME : TokenType.LOGIN);
        apiAuthAccessTokenCreationRequest.setActive(true);
        apiAuthAccessTokenCreationRequest.setExpires(new Date());
        return apiAuthAccessTokenCreationRequest;
    }
}

package com.attendance_tracker.facade.authentication.impl;


import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.facade.authentication.AuthenticationFacade;
import com.attendance_tracker.facade.authentication.exception.AuthException;
import com.attendance_tracker.facade.authentication.model.AuthenticationRequest;
import com.attendance_tracker.facade.authentication.model.AuthenticationResponse;
import com.attendance_tracker.facade.authentication.model.TokenAuthenticationRequest;
import com.attendance_tracker.facade.strategy.UserCredentialValidationStrategy;
import com.attendance_tracker.misc.TokenType;
import com.attendance_tracker.service.api_auth_access_token.ApiAuthAccessTokenService;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.user_detail.ApiUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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
    public AuthenticationResponse authenticateByCredentials(final AuthenticationRequest request) throws AuthException {
        notNull(request, "authenticationRequest.request cannot be null.");
        final String username = request.getUsername();
        final String plainPassword = request.getPlainPassword();
        notNull(username, "authenticationRequest.request.username cannot be null.");
        notNull(plainPassword, "authenticationRequest.request.plainPassword cannot be null.");

        logger.debug("Attempting authentication with username:'{}'...", username);
        final APIUserDetail userDetail = apiUserDetailService.loadUserByUsername(username);
        logger.trace("Found authority:'{}' by username.", userDetail.getId());

        userCredentialValidationStrategy.validateForAuthentication(userDetail);

        final String userId = userDetail.getUser().getId();

        final ApiAuthAccessTokenCreationRequest apiAuthAccessTokenCreationRequest = create(userDetail, request.isRememberMe(), request.getDescription());

        logger.debug("Creating apiAuthAccessToken for user:'{}'...", userId);
        final ApiAuthAccessToken apiAuthAccessToken = apiAuthAccessTokenService.createApiAccessToken(apiAuthAccessTokenCreationRequest);
        logger.trace("ApiAuthAccessToken:'{}' is created for user:'{}'.", apiAuthAccessToken.getToken(), userId);

        return new AuthenticationResponse(userId, apiAuthAccessToken.getToken(),apiAuthAccessToken.getExpires());
    }

    @Override
    public AuthenticationResponse authenticateByRememberMeToken(final TokenAuthenticationRequest request) throws AuthException {
        return null;
    }

    @Override
    public ApiAuthAccessToken authenticateByApiAccessToken(final String token) throws AuthException {
        return null;
    }

    private ApiAuthAccessTokenCreationRequest create(final APIUserDetail userDetail, final boolean isRememberMe, final String description){
        final ApiAuthAccessTokenCreationRequest apiAuthAccessTokenCreationRequest = new ApiAuthAccessTokenCreationRequest();
        apiAuthAccessTokenCreationRequest.setUserDetail(userDetail);
        apiAuthAccessTokenCreationRequest.setDescription(description);
        apiAuthAccessTokenCreationRequest.setTokenType(isRememberMe ? TokenType.LOGIN_REMEMBER_ME : TokenType.LOGIN);
        apiAuthAccessTokenCreationRequest.setActive(true);
        return apiAuthAccessTokenCreationRequest;
    }
}

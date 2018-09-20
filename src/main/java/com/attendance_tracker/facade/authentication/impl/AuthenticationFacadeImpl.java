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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public AuthenticationResponse authenticateByCredentials(final AuthenticationRequest request) {
        notNull(request, "authenticationRequest.request cannot be null.");
        final String username = request.getUsername();
        final String plainPassword = request.getPlainPassword();
        notNull(username, "authenticationRequest.request.username cannot be null.");
        notNull(plainPassword, "authenticationRequest.request.plainPassword cannot be null.");

        logger.debug("Attempting authentication with username:'{}'...", username);
        final APIUserDetail userDetail = apiUserDetailService.loadUserByUsername(username);
        logger.trace("Found authority:'{}' by username.", userDetail.getId());

        final String userId = userDetail.getUser().getId();

        ApiAuthAccessToken existingToken = apiAuthAccessTokenService.findByUserDetailId(userDetail.getId()).orElse(null);

        if (existingToken == null) {
            userCredentialValidationStrategy.validateForAuthentication(userDetail);
            final ApiAuthAccessTokenCreationRequest apiAuthAccessTokenCreationRequest = create(userDetail, request.isRememberMe());

            logger.debug("Creating apiAuthAccessToken for user:'{}'...", userId);
            final ApiAuthAccessToken apiAuthAccessToken = apiAuthAccessTokenService.createApiAccessToken(apiAuthAccessTokenCreationRequest);
            logger.trace("ApiAuthAccessToken:'{}' is created for user:'{}'.", apiAuthAccessToken.getToken(), userId);
            return new AuthenticationResponse(userDetail, apiAuthAccessToken.getToken());
        } else {
            existingToken = authenticateByApiAccessToken(existingToken.getToken());
            if(existingToken == null){
                return null;
            }
            return new AuthenticationResponse(userDetail, existingToken.getToken());
        }
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return new APIAuthenticationResponse(authenticateByCredentials((AuthenticationRequest) authentication.getDetails()));
    }

    @Override
    public ApiAuthAccessToken authenticateByApiAccessToken(final String token) throws AuthException {
        ApiAuthAccessToken existingToken = apiAuthAccessTokenService.findByToken(token).orElse(null);
        if (existingToken == null || !isValid(existingToken)) {
            return null;
        } else {
            final LocalDateTime expires = existingToken.getExpires();
            if (isRememberMe(existingToken) && (isExpired(expires) || isExpiring(expires))) {
                final ApiAuthAccessTokenRefreshRequest apiAuthAccessTokenRefreshRequest = new ApiAuthAccessTokenRefreshRequest(existingToken);
                existingToken = apiAuthAccessTokenService.updateApiAccessToken(apiAuthAccessTokenRefreshRequest);
            } else {
                if (isExpired(expires)) {
                    final ApiAuthAccessTokenRefreshRequest apiAuthAccessTokenRefreshRequest = new ApiAuthAccessTokenRefreshRequest(existingToken);
                    apiAuthAccessTokenService.inactivateApiAccessToken(apiAuthAccessTokenRefreshRequest);
                    return null;
                }
            }
            logger.debug("Refreshing apiAuthAccessToken for user:'{}'...", existingToken.getApiUserDetail().getUser().getId());
            logger.trace("ApiAuthAccessToken:'{}' is refreshed for user:'{}'.", existingToken.getToken(), existingToken.getApiUserDetail().getUser().getId());
            return existingToken;
        }
    }

    private ApiAuthAccessTokenCreationRequest create(final APIUserDetail userDetail, final boolean isRememberMe) {
        final ApiAuthAccessTokenCreationRequest apiAuthAccessTokenCreationRequest = new ApiAuthAccessTokenCreationRequest();
        apiAuthAccessTokenCreationRequest.setUserDetail(userDetail);
        apiAuthAccessTokenCreationRequest.setTokenType(isRememberMe ? TokenType.LOGIN_REMEMBER_ME : TokenType.LOGIN);
        apiAuthAccessTokenCreationRequest.setActive(true);
        apiAuthAccessTokenCreationRequest.setExpires(new Date());
        return apiAuthAccessTokenCreationRequest;
    }

    private boolean isExpiring(final LocalDateTime expirationTime) {
        return expirationTime.plusMinutes(1).isAfter(LocalDateTime.now());
    }

    private boolean isExpired(final LocalDateTime expirationTime) {
        return expirationTime.isBefore(LocalDateTime.now());
    }

    private boolean isValid(final ApiAuthAccessToken existingToken) {
        return existingToken.getActive() && !existingToken.isDeleted();
    }

    private boolean isRememberMe(final ApiAuthAccessToken existingToken) {
        return existingToken.getTokenType().equals(TokenType.LOGIN_REMEMBER_ME);
    }
}

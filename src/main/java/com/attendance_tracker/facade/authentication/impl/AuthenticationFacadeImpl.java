package com.attendance_tracker.facade.authentication.impl;


import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.facade.authentication.AuthModelConverter;
import com.attendance_tracker.facade.authentication.AuthenticationFacade;
import com.attendance_tracker.facade.authentication.exception.AuthException;
import com.attendance_tracker.facade.authentication.model.APIAuthenticationResponse;
import com.attendance_tracker.facade.authentication.model.AuthenticationRequest;
import com.attendance_tracker.facade.authentication.model.AuthenticationResponse;
import com.attendance_tracker.facade.strategy.AuthValidationStrategy;
import com.attendance_tracker.service.api_auth_access_token.ApiAuthAccessTokenService;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenRequest;
import com.attendance_tracker.service.user_detail.ApiUserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationFacadeImpl implements AuthenticationFacade {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationFacadeImpl.class);

    @Autowired
    private ApiUserDetailService apiUserDetailService;

    @Autowired
    private ApiAuthAccessTokenService apiAuthAccessTokenService;

    @Autowired
    private AuthValidationStrategy authValidationStrategy;

    @Value("#{'${authenticationService.masterApiUserDetail.passwordHash}' ?: null}")
    private String masterApiUserDetailPasswordHash;

    @Override
    public AuthenticationResponse authenticateByCredentials(final AuthenticationRequest request) throws AuthException {
        authValidationStrategy.validate(request);
        final APIUserDetail userDetail = apiUserDetailService.loadUserByUsername(request.getUsername());
        authValidationStrategy.validate(userDetail);
        final ApiAuthAccessToken apiAuthAccessToken = apiAuthAccessTokenService.createApiAccessToken(AuthModelConverter.convert(userDetail, request.isRememberMe()));
        return new AuthenticationResponse(userDetail, apiAuthAccessToken.getToken());
    }

    @Override
    public AuthenticationResponse authenticateByApiAccessToken(final String token) throws AuthException {
        ApiAuthAccessToken existingToken = apiAuthAccessTokenService.findByToken(token).orElse(null);
        authValidationStrategy.validateForRefreshing(existingToken);
        if (authValidationStrategy.isExpiredLoginToken(existingToken)) {
            apiAuthAccessTokenService.inactivateApiAccessToken(new ApiAuthAccessTokenRequest(existingToken));
            throw new AuthException(String.format("Api user access token is expired:'%s'.", existingToken.getApiUserDetail().getUser().getId()));
        }
        if (authValidationStrategy.isExpiringRefreshToken(existingToken)) {
            existingToken = apiAuthAccessTokenService.refreshApiAccessToken(new ApiAuthAccessTokenRequest(existingToken));
        }
        return new AuthenticationResponse(existingToken.getApiUserDetail(), existingToken.getToken());
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthException {
        return new APIAuthenticationResponse(authenticateByCredentials((AuthenticationRequest) authentication.getDetails()));
    }


}

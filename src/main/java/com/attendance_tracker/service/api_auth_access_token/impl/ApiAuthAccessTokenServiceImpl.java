package com.attendance_tracker.service.api_auth_access_token.impl;


import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.misc.TokenType;
import com.attendance_tracker.service.api_auth_access_token.ApiAuthAccessTokenService;
import com.attendance_tracker.service.api_auth_access_token.exception.ApiAuthAccessTokenNotFoundException;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenRefreshRequest;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.Assert.notNull;

@Service
public class ApiAuthAccessTokenServiceImpl implements ApiAuthAccessTokenService {



    @Override
    public ApiAuthAccessToken getById(final Long id) {
        return null;
    }

    @Override
    public ApiAuthAccessToken getApiAccessToken(final String token) throws ApiAuthAccessTokenNotFoundException {
        return null;
    }

    @Override
    public ApiAuthAccessToken createApiAccessToken(final ApiAuthAccessTokenCreationRequest request) {
        notNull(request, "request can not be null");
        final APIUserDetail userDetail = request.getUserDetail();
        final TokenType tokenType = request.getTokenType();
        final String description = request.getDescription();

        return null;
    }

    @Override
    public ApiAuthAccessToken updateApiAccessToken(final ApiAuthAccessTokenRefreshRequest request) {
        return null;
    }

    @Override
    public void deleteApiAccessToken(final long apiAccessTokenId) {

    }

    @Override
    public List<ApiAuthAccessToken> getApiAccessTokens() {
        return null;
    }
}

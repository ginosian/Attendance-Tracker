package com.attendance_tracker.service.api_auth_access_token.impl;


import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.service.api_auth_access_token.ApiAuthAccessTokenService;
import com.attendance_tracker.service.api_auth_access_token.exception.ApiAuthAccessTokenNotFoundException;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiAuthAccessTokenServiceImpl implements ApiAuthAccessTokenService {

    @Override
    public ApiAuthAccessToken getById(final long id) {
        return null;
    }

    @Override
    public ApiAuthAccessToken getApiAccessToken(final String token) throws ApiAuthAccessTokenNotFoundException {
        return null;
    }

    @Override
    public ApiAuthAccessToken createApiAccessToken(final ApiAuthAccessTokenCreationRequest request) {
        return null;
    }

    @Override
    public ApiAuthAccessToken updateApiAccessToken(final ApiAuthAccessTokenUpdateRequest request) {
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

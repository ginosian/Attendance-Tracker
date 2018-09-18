package com.attendance_tracker.service.api_auth_access_token;

import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.service.api_auth_access_token.exception.ApiAuthAccessTokenNotFoundException;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenRefreshRequest;

import java.util.List;

public interface ApiAuthAccessTokenService {

    ApiAuthAccessToken getById(Long id);

    ApiAuthAccessToken getApiAccessToken(String token) throws ApiAuthAccessTokenNotFoundException;

    ApiAuthAccessToken createApiAccessToken(ApiAuthAccessTokenCreationRequest request);

    ApiAuthAccessToken updateApiAccessToken(ApiAuthAccessTokenRefreshRequest request);

    void deleteApiAccessToken(long apiAccessTokenId);

    List<ApiAuthAccessToken> getApiAccessTokens();

}

package com.attendance_tracker.service.api_auth_access_token;

import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenRefreshRequest;

import java.util.List;
import java.util.Optional;

public interface ApiAuthAccessTokenService {

    Optional<ApiAuthAccessToken> findByUserDetail(String userDetailId);

    Optional<ApiAuthAccessToken> findByApiAccessToken(String token);

    ApiAuthAccessToken createApiAccessToken(ApiAuthAccessTokenCreationRequest request);

    ApiAuthAccessToken updateApiAccessToken(ApiAuthAccessTokenRefreshRequest request);

    void deleteApiAccessToken(long apiAccessTokenId);

    List<ApiAuthAccessToken> getApiAccessTokens();

}

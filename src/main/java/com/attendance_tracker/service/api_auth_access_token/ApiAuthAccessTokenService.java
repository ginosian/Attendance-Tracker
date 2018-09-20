package com.attendance_tracker.service.api_auth_access_token;

import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenRefreshRequest;

import java.util.Optional;

public interface ApiAuthAccessTokenService {

    Optional<ApiAuthAccessToken> findByToken(String token);

    Optional<ApiAuthAccessToken> findByUserDetailId(String userDetailId);

    ApiAuthAccessToken createApiAccessToken(ApiAuthAccessTokenCreationRequest request);

    ApiAuthAccessToken updateApiAccessToken(ApiAuthAccessTokenRefreshRequest request);

    ApiAuthAccessToken inactivateApiAccessToken(ApiAuthAccessTokenRefreshRequest request);
}

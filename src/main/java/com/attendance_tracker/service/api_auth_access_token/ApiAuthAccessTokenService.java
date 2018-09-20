package com.attendance_tracker.service.api_auth_access_token;

import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenRequest;

import java.util.Optional;

public interface ApiAuthAccessTokenService {

    Optional<ApiAuthAccessToken> findByToken(String token);

    Optional<ApiAuthAccessToken> findByUserDetailId(String userDetailId);

    ApiAuthAccessToken createApiAccessToken(ApiAuthAccessTokenCreationRequest request);

    ApiAuthAccessToken refreshApiAccessToken(ApiAuthAccessTokenRequest request);

    ApiAuthAccessToken inactivateApiAccessToken(ApiAuthAccessTokenRequest request);
}

package com.attendance_tracker.service.api_auth_access_token;

import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.service.api_auth_access_token.exception.ApiAuthAccessTokenNotFoundException;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenUpdateRequest;

import java.util.List;

public interface ApiAuthAccessTokenService {

    ApiAuthAccessToken getById(long id);

    ApiAuthAccessToken getApiAccessToken(String token) throws ApiAuthAccessTokenNotFoundException;

    ApiAuthAccessToken createApiAccessToken(ApiAuthAccessTokenCreationRequest request);

    ApiAuthAccessToken updateApiAccessToken(ApiAuthAccessTokenUpdateRequest request);

    void deleteApiAccessToken(long apiAccessTokenId);

    List<ApiAuthAccessToken> getApiAccessTokens();

}

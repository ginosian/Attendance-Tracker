package com.attendance_tracker.service.token;

import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenRefreshRequest;

public interface TokenService {

    String createNewToken(ApiAuthAccessTokenCreationRequest request);

    String refreshToken(ApiAuthAccessTokenRefreshRequest request);

    String getUsernameFromToken(String token);

    String getPasswordHashFromToken(String token);
}

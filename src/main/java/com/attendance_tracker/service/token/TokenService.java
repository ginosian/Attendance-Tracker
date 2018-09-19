package com.attendance_tracker.service.token;

import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;

import java.util.Date;

public interface TokenService {

    String create(ApiAuthAccessTokenCreationRequest request);

    String refresh(final String token, final Date expires);

    String getUsername(String token);

    String getPasswordHash(String token);
}

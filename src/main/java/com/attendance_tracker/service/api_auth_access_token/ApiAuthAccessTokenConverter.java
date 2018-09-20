package com.attendance_tracker.service.api_auth_access_token;


import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;

import java.time.ZoneId;

public class ApiAuthAccessTokenConverter {

    public static final ApiAuthAccessToken convert(final ApiAuthAccessTokenCreationRequest request, final String token){
        final  ApiAuthAccessToken apiAuthAccessToken = new ApiAuthAccessToken();
        apiAuthAccessToken.setToken(token);
        apiAuthAccessToken.setTokenType(request.getTokenType());
        apiAuthAccessToken.setActive(true);
        apiAuthAccessToken.setApiUserDetail(request.getUserDetail());
        apiAuthAccessToken.setExpires(request.getExpires().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        return apiAuthAccessToken;
    }

}

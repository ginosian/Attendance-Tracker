package com.attendance_tracker.service.api_auth_access_token.model;

import com.attendance_tracker.entity.ApiAuthAccessToken;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiAuthAccessTokenRefreshRequest {
    private ApiAuthAccessToken token;
}

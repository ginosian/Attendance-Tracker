package com.attendance_tracker.service.api_auth_access_token.model;

import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.misc.TokenType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiAuthAccessTokenCreationRequest {
    private APIUserDetail userDetail;
    private TokenType tokenType;
    private boolean isActive;
    private Date expires;
}

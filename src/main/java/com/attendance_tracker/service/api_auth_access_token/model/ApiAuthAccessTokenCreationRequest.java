package com.attendance_tracker.service.api_auth_access_token.model;

import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.misc.TokenType;

public class ApiAuthAccessTokenCreationRequest {

    private APIUserDetail userDetail;
    private TokenType tokenType;
    private String description;

    public APIUserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(APIUserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

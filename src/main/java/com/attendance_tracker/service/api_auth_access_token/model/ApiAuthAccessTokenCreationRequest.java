package com.attendance_tracker.service.api_auth_access_token.model;

import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.misc.TokenType;

import java.util.Date;

public class ApiAuthAccessTokenCreationRequest {

    private APIUserDetail userDetail;
    private TokenType tokenType;
    private boolean isActive;
    private Date expires;

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }
}

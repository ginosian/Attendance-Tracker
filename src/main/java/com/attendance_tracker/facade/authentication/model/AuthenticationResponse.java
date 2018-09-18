package com.attendance_tracker.facade.authentication.model;

import com.attendance_tracker.entity.APIUserDetail;

public class AuthenticationResponse{

    private APIUserDetail apiUserDetail;
    private String token;

    public AuthenticationResponse(APIUserDetail apiUserDetail, String token) {
        this.apiUserDetail = apiUserDetail;
        this.token = token;
    }

    public APIUserDetail getApiUserDetail() {
        return apiUserDetail;
    }

    public void setApiUserDetail(APIUserDetail apiUserDetail) {
        this.apiUserDetail = apiUserDetail;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

package com.attendance_tracker.service.api_auth_access_token.model;

public class ApiAuthAccessTokenUpdateRequest {

    private Long apiAuthAccessTokenId;

    private String description;

    public Long getApiAuthAccessTokenId() {
        return apiAuthAccessTokenId;
    }

    public void setApiAuthAccessTokenId(Long apiAuthAccessTokenId) {
        this.apiAuthAccessTokenId = apiAuthAccessTokenId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

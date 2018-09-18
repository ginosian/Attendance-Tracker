package com.attendance_tracker.service.api_auth_access_token.model;

public class ApiAuthAccessTokenCreationRequest {

    private Long userId;

    private Long roleId;

    private Boolean isActive;

    private String token;

    private String description;
}

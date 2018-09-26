package com.attendance_tracker.keycloak.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeycloakClient {
    private String id;
    private String clientId;
    private String name;
    private String description;
    private String rootUrl;
    private String adminUrl;
    private String baseUrl;
    private List<String> redirectUris;
    private boolean enabled;
    private String clientAuthenticatorType;
    private String secret;
    private String registrationAccessToken;
    private boolean bearerOnly;
    private boolean directAccessGrantsEnabled;
    private boolean directGrantsOnly;
    private boolean publicClient;
}

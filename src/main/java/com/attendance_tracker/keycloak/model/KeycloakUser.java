package com.attendance_tracker.keycloak.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeycloakUser {
    private String id;
    private String origin;
    private String username;
    private Boolean enabled;
    private Boolean emailVerified;
    private String firstName;
    private String lastName;
    private String email;
    private List<KeycloakCredentials> credentials;
    private List<String> requiredActions;
    private List<String> realmRoles;
    private Map<String, List<String>> clientRoles;
    private List<String> groups;
}

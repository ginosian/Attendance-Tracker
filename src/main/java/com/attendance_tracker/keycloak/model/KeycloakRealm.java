package com.attendance_tracker.keycloak.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeycloakRealm {
    private String id;
    private String realm;
    private String displayName;
    private int accessTokenLifespan;
    private boolean enabled;
    private boolean registrationAllowed;
    private boolean registrationEmailAsUsername;
    private boolean rememberMe;
    private boolean verifyEmail;
    private boolean loginWithEmailAllowed;
    private boolean duplicateEmailsAllowed;
    private boolean resetPasswordAllowed;
    private boolean editUsernameAllowed;
    private boolean userManagedAccessAllowed;
    private KeycloakRole roles;
    private List<KeycloakGroup> groups;
    private List<KeycloakUser> users;
    private List<KeycloakClient> clients;
}

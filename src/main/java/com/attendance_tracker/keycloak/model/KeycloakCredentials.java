package com.attendance_tracker.keycloak.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeycloakCredentials {
    protected String type;
    protected String salt;
    private String algorithm;
}

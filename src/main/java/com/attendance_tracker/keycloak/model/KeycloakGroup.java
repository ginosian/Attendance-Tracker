package com.attendance_tracker.keycloak.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeycloakGroup {
    private String id;
    private String name;
    private String path;
    private List<String> realmRoles;
    private Map<String, List<String>> clientRoles;
    private List<KeycloakGroup> subGroups;
}

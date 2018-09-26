package com.attendance_tracker.keycloak;

import org.keycloak.representations.idm.RoleRepresentation;

import java.util.List;

public interface KeycloakApiClient {

    String getMasterToken();

    List<RoleRepresentation> allRoles();

    String createRole();

    String createUser();

}

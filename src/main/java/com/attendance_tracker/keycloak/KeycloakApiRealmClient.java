package com.attendance_tracker.keycloak;

import com.attendance_tracker.keycloak.model.KeycloakClient;
import com.attendance_tracker.keycloak.model.KeycloakGroup;
import com.attendance_tracker.keycloak.model.KeycloakRole;
import com.attendance_tracker.keycloak.model.KeycloakUser;

import java.util.List;

public interface KeycloakApiRealmClient {

    KeycloakClient saveClient(KeycloakClient clientDto, String realm);

    KeycloakClient getClient(String clientId, String realm);

    List<KeycloakClient> getAllClients(String realm);

    KeycloakGroup saveGroup(KeycloakGroup groupDto, String realm);

    KeycloakGroup getGroup(String id, String realm);

    List<KeycloakGroup> getAllGroups(String realm);

    void saveRole(KeycloakRole roleDto, String realm);

    KeycloakRole getRole(String id, String realm);

    List<KeycloakRole> getAllRoles(String realm);

    KeycloakUser saveUser(KeycloakUser userDto, String realm);

    KeycloakUser getUser(String id, String realm);

    List<KeycloakUser> getAllUsers(String realm);
}

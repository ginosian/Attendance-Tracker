package com.attendance_tracker.keycloak;

import com.attendance_tracker.keycloak.model.*;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;

public class MockOwnerData {

    public static KeycloakRealm createRealm(
            final KeycloakRole roles,
            final List<KeycloakGroup> groups,
            final List<KeycloakUser> users,
            final List<KeycloakClient> clients
    ) {
        final KeycloakRealm keycloakRealm = new KeycloakRealm();
        keycloakRealm.setRealm("owner");
        keycloakRealm.setDisplayName("Owner");
        keycloakRealm.setAccessTokenLifespan(600);
        keycloakRealm.setEnabled(true);
        keycloakRealm.setRegistrationAllowed(true);
        keycloakRealm.setRegistrationEmailAsUsername(true);
        keycloakRealm.setRememberMe(true);
        keycloakRealm.setVerifyEmail(false);
        keycloakRealm.setLoginWithEmailAllowed(true);
        keycloakRealm.setDuplicateEmailsAllowed(false);
        keycloakRealm.setResetPasswordAllowed(true);
        keycloakRealm.setEditUsernameAllowed(true);
        keycloakRealm.setUserManagedAccessAllowed(false);
        keycloakRealm.setRoles(roles);
        keycloakRealm.setGroups(groups);
        keycloakRealm.setUsers(users);
        keycloakRealm.setClients(clients);
        return keycloakRealm;
    }

    public static KeycloakClient createClient() {
        final KeycloakClient keycloakClient = new KeycloakClient();
        keycloakClient.setClientId("owner_client");
        keycloakClient.setName("Owner Client");
        keycloakClient.setDescription("Owner of this application");
        keycloakClient.setRootUrl(null);
        keycloakClient.setAdminUrl(null);
        keycloakClient.setBaseUrl(null);
        keycloakClient.setEnabled(true);
        keycloakClient.setRedirectUris(Lists.newArrayList("http://localhost:8080/owner"));
        keycloakClient.setClientAuthenticatorType(null);
        keycloakClient.setSecret("owner_client_secret");
        keycloakClient.setRegistrationAccessToken("owner_registration_access_token");
        keycloakClient.setBearerOnly(true);
        keycloakClient.setDirectAccessGrantsEnabled(true);
        keycloakClient.setDirectGrantsOnly(false);
        keycloakClient.setPublicClient(true);
        return keycloakClient;
    }

    public static KeycloakGroup createGroup(
            final List<String> realmRoles,
            final Map<String, List<String>> clientRoles,
            final List<KeycloakGroup> subGroups
    ) {
        final KeycloakGroup keycloakGroup = new KeycloakGroup();
        keycloakGroup.setName("Owner");
        keycloakGroup.setPath(null);
        keycloakGroup.setRealmRoles(realmRoles);
        keycloakGroup.setClientRoles(clientRoles);
        keycloakGroup.setSubGroups(subGroups);
        return keycloakGroup;
    }

    public static KeycloakRole createRole(
            final String role,
            final boolean clientRole,
            final String containerId
    ) {
        final KeycloakRole keycloakRole = new KeycloakRole();
        keycloakRole.setName(role);
        keycloakRole.setDescription(null);
        keycloakRole.setComposite(true);
        keycloakRole.setClientRole(clientRole);
        keycloakRole.setContainerId(containerId);
        return keycloakRole;
    }

    public static KeycloakUser createUser(
            final List<String> realmRoles,
            final Map<String, List<String>> clientRoles,
            final List<String> groups
    ) {
        final KeycloakUser keycloakUser = new KeycloakUser();
        keycloakUser.setOrigin(null);
        keycloakUser.setUsername("ginosian");
        keycloakUser.setEnabled(true);
        keycloakUser.setEmailVerified(true);
        keycloakUser.setFirstName("Marta");
        keycloakUser.setLastName("Ginosyan");
        keycloakUser.setEmail("marta.ginosian@gmail.com");

        final KeycloakCredentials keycloakCredentials = new KeycloakCredentials();
        keycloakCredentials.setType("password");
        keycloakUser.setCredentials(Lists.newArrayList(keycloakCredentials));
        keycloakUser.setRequiredActions(null);
        keycloakUser.setRealmRoles(realmRoles);
        keycloakUser.setClientRoles(clientRoles);
        keycloakUser.setGroups(groups);
        return keycloakUser;
    }

}

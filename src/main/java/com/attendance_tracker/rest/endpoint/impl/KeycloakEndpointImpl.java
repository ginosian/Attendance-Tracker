package com.attendance_tracker.rest.endpoint.impl;

import com.attendance_tracker.keycloak.KeycloakApiClient;
import com.attendance_tracker.rest.endpoint.KeycloakEndpoint;
import org.keycloak.admin.client.resource.RealmResource;
import org.springframework.beans.factory.annotation.Autowired;

public class KeycloakEndpointImpl implements KeycloakEndpoint {

    String serverUrl = "http://localhost:8088/auth";
    String realm = "attendance_tracker";
    String clientId = "attendance_tracker";
    String clientSecret = "c2a351bd-75b1-4524-b70c-5dac6cd17027";

    @Autowired
    private KeycloakApiClient keycloakApiClient;

    @Override
    public RealmResource realms() {

        keycloakApiClient.createRole();
        keycloakApiClient.createUser();

//        final String token = keycloakApiClient.getToken(realm);
//
//        Keycloak keycloak = Keycloak.getInstance(
//                "http://localhost:8088/auth",
//                "master",
//                "ginosyan",
//                "margin",
//                "admin-cli");
//        RealmRepresentation realm = keycloak.realm("attendance_tracker").toRepresentation();
//        System.out.println();
//        return null;
//        // Client "idm-client" needs service-account with at least "manage-users, view-clients, view-realm, view-users" roles for "realm-management"
////		Keycloak keycloak = KeycloakBuilder.builder() //
////				.serverUrl(serverUrl) //
////				.realm(realm) //
////				.grantType(OAuth2Constants.CLIENT_CREDENTIALS) //
////				.clientId(clientId) //
////				.clientSecret(clientSecret).build();
//
//        // User "idm-admin" needs at least "manage-users, view-clients, view-realm, view-users" roles for "realm-management"
////        Keycloak keycloak = KeycloakBuilder.builder()
////                .serverUrl(serverUrl)
////                .realm(realm)
////                .grantType(OAuth2Constants.PASSWORD)
////                .clientId(clientId)
////                .clientSecret(clientSecret)
////                .username("ginosyan")
////                .password("margin")
////                .build();
////
////        final RealmResource realmResource = (RealmResource) keycloak.realms();
////        return realmResource;
//
////        // Define user
////        UserRepresentation user = new UserRepresentation();
////        user.setEnabled(true);
////        user.setUsername("tester1");
////        user.setFirstName("First");
////        user.setLastName("Last");
////        user.setEmail("tom+tester1@tdlabs.local");
////        user.setAttributes(Collections.singletonMap("origin", Arrays.asList("demo")));
////
////        // Get realm
////        RealmResource realmResource = keycloak.realm(realm);
////        UsersResource userRessource = realmResource.users();
////
////        // Create user (requires manage-users role)
////        Response response = userRessource.create(user);
////        System.out.println("Repsonse: " + response.getStatusInfo());
////        System.out.println(response.getLocation());
////        String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");
////
////        System.out.printf("User created with userId: %s%n", userId);
////
////        // Get realm role "tester" (requires view-realm role)
////        RoleRepresentation testerRealmRole = realmResource.roles()//
////                .get("tester").toRepresentation();
////
////        // Assign realm role tester to user
////        userRessource.get(userId).roles().realmLevel() //
////                .add(Arrays.asList(testerRealmRole));
////
////        // Get client
////        ClientRepresentation app1Client = realmResource.clients() //
////                .findByClientId("app-javaee-petclinic").get(0);
////
////        // Get client level role (requires view-clients role)
////        RoleRepresentation userClientRole = realmResource.clients().get(app1Client.getId()) //
////                .roles().get("user").toRepresentation();
////
////        // Assign client level role to user
////        userRessource.get(userId).roles() //
////                .clientLevel(app1Client.getId()).add(Arrays.asList(userClientRole));
////
////        // Define password credential
////        CredentialRepresentation passwordCred = new CredentialRepresentation();
////        passwordCred.setTemporary(false);
////        passwordCred.setType(CredentialRepresentation.PASSWORD);
////        passwordCred.setValue("test");
////
////        // Set password credential
////        userRessource.get(userId).resetPassword(passwordCred);
        return null;
    }
}

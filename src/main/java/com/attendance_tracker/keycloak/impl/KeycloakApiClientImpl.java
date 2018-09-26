package com.attendance_tracker.keycloak.impl;

import com.attendance_tracker.keycloak.KeycloakApiClient;
import com.attendance_tracker.keycloak.exception.KeycloakException;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.List;


@Component
@PropertySource("classpath:application-keycloak.properties")
public class KeycloakApiClientImpl implements KeycloakApiClient {

    @Value("${auth-server-url}")
    private String auth_server_url;
    @Value("${attendance.tracker.realm}")
    private String realm;
    @Value("${attendance.tracker.username}")
    private String username;
    @Value("${attendance.tracker.password}")
    private String password;
    @Value("${attendance.tracker.client.id}")
    private String client_id;
    @Value("${attendance.tracker.client.secret}")
    private String client_secret;
    @Value("${master.realm}")
    private String master_realm;
    @Value("${master.username}")
    private String master_username;
    @Value("${master.password}")
    private String master_password;
    @Value("${master.client.id}")
    private String master_client_id;

    @Override
    public String getMasterToken() {
        return adminClient().tokenManager().getAccessToken().getToken();
    }

    private Keycloak adminClient(){
        return Keycloak.getInstance(auth_server_url, master_realm, master_username, master_password, master_client_id);
    }

    @Override
    public List<RoleRepresentation> allRoles(){
        return adminClient().realm(realm).roles().list();
    }

    @Override
    public String createRole(){
        final RoleRepresentation roleRepresentation = new RoleRepresentation();
        roleRepresentation.setComposite(false);
        roleRepresentation.setName("OWNER_ADMIN");
        roleRepresentation.setDescription("For administration staff of application owner.");
        roleRepresentation.setId("my db id");
        adminClient().realm(realm).roles().create(roleRepresentation);
        return null;
    }


    public void allUsers(){

    }


    @Override
    public String createUser(){
        final UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setId("my db id");
        userRepresentation.setUsername("my username");
        userRepresentation.setEmail("marta.h.ginosyan@gmail.com");
        userRepresentation.setFirstName("Marta");
        userRepresentation.setLastName("Ginosyan");
        userRepresentation.setEmailVerified(false);
        final Response response =  adminClient().realm(realm).users().create(userRepresentation);
        if(response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            return response.getLocation().getPath();
        } else {
            throw new KeycloakException(null, null, null);
        }
    }

    public void addRoleToUser(){
    }

}

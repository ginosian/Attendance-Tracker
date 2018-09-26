package com.attendance_tracker.keycloak.impl;

import com.attendance_tracker.keycloak.KeycloakApiMasterRealmClient;
import com.attendance_tracker.keycloak.KeycloakApiRealmClient;
import com.attendance_tracker.keycloak.exception.KeycloakException;
import com.attendance_tracker.keycloak.model.KeycloakClient;
import com.attendance_tracker.keycloak.model.KeycloakGroup;
import com.attendance_tracker.keycloak.model.KeycloakRole;
import com.attendance_tracker.keycloak.model.KeycloakUser;
import com.attendance_tracker.mapper.BeanMapper;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.List;

@Component
@PropertySource("classpath:application-keycloak.properties")
public class KeycloakApiRealmClientImpl implements KeycloakApiRealmClient {

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

    @Autowired
    private BeanMapper beanMapper;

    @Autowired
    private KeycloakApiMasterRealmClient admin;

    // region CLIENT
    public KeycloakClient saveClient(final KeycloakClient clientDto, final String realm){
        final ClientRepresentation clientRepresentation = beanMapper.map(clientDto, ClientRepresentation.class);
        return beanMapper.map(getResponseEntity(admin.client().realm(realm).clients().create(clientRepresentation)), KeycloakClient.class);
    }

    public KeycloakClient getClient(final String clientId, final String realm){
        return beanMapper.map(admin.client().realm(realm).clients().findByClientId(clientId),KeycloakClient.class);
    }

    public List<KeycloakClient> getAllClients(final String realm){
        return beanMapper.mapAsList(admin.client().realm(realm).clients().findAll(), KeycloakClient.class);
    }
    // endregion

    // region GROUP
    public KeycloakGroup saveGroup(final KeycloakGroup groupDto, final String realm) {
        final GroupRepresentation groupRepresentation = beanMapper.map(groupDto, GroupRepresentation.class);
        return beanMapper.map(getResponseEntity(admin.client().realm(realm).groups().add(groupRepresentation)), KeycloakGroup.class);
    }

    public KeycloakGroup getGroup(final String id, final String realm){
        return beanMapper.map(admin.client().realm(realm).groups().group(id),KeycloakGroup.class);
    }

    public List<KeycloakGroup> getAllGroups(final String realm){
        return beanMapper.mapAsList(admin.client().realm(realm).groups().groups(), KeycloakGroup.class);
    }
    // endregion

    // region ROLE
    @Override
    public void saveRole(final KeycloakRole roleDto, final String realm) {
        final RoleRepresentation roleRepresentation = beanMapper.map(roleDto, RoleRepresentation.class);
        admin.client().realm(realm).roles().create(roleRepresentation);
    }

    public KeycloakRole getRole(final String id, final String realm){
        return beanMapper.map(admin.client().realm(realm).roles().get(id).toRepresentation(),KeycloakRole.class);
    }

    public List<KeycloakRole> getAllRoles(final String realm){
        return beanMapper.mapAsList(admin.client().realm(realm).roles().list(), KeycloakRole.class);
    }
    // endregion

    // region USER
    @Override
    public KeycloakUser saveUser(final KeycloakUser userDto, final String realm) {
        final UserRepresentation userRepresentation = beanMapper.map(userDto, UserRepresentation.class);
        return beanMapper.map(getResponseEntity(admin.client().realm(realm).users().create(userRepresentation)), KeycloakUser.class);
    }

    public KeycloakUser getUser(final String id, final String realm){
        return beanMapper.map(admin.client().realm(realm).users().get(id).toRepresentation(),KeycloakUser.class);
    }

    public List<KeycloakUser> getAllUsers(final String realm){
        return beanMapper.mapAsList(admin.client().realm(realm).users().list(), KeycloakUser.class);
    }
    // endregion

    private Object getResponseEntity(final Response response) {
        if (response.getStatusInfo().getFamily().equals(Response.Status.Family.SUCCESSFUL)) {
            return response.getEntity();
        } else {
            throw new KeycloakException(null, null, null);
        }
    }
}

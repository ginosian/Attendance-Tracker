package com.attendance_tracker.keycloak.impl;

import com.attendance_tracker.keycloak.KeycloakApiMasterRealmClient;
import com.attendance_tracker.keycloak.model.KeycloakRealm;
import com.attendance_tracker.mapper.BeanMapper;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@PropertySource("classpath:application-keycloak.properties")
public class KeycloakApiMasterRealmClientImpl implements KeycloakApiMasterRealmClient {

    @Autowired
    private BeanMapper beanMapper;

    @Value("${auth-server-url}")
    private String auth_server_url;
    @Value("${master.realm}")
    private String master_realm;
    @Value("${master.username}")
    private String master_username;
    @Value("${master.password}")
    private String master_password;
    @Value("${master.client.id}")
    private String master_client_id;


    // region REALM
    public KeycloakRealm saveRealm(final KeycloakRealm realmDto) {
        final RealmRepresentation realmRepresentation = beanMapper.map(realmDto, RealmRepresentation.class);
        realmRepresentation.setKeycloakVersion("4.4.0.Final");
        client().realms().create(realmRepresentation);
        return beanMapper.map(client().realms().realm(realmDto.getRealm()).toRepresentation(), KeycloakRealm.class);
    }

    public KeycloakRealm getRealm(final String id) {
        return beanMapper.map(client().realms().realm(id).toRepresentation(), KeycloakRealm.class);
    }

    public List<KeycloakRealm> getAllRealms() {
        return beanMapper.mapAsList(client().realms().findAll(), KeycloakRealm.class);
    }
    // endregion

    public Keycloak client() {

        return KeycloakBuilder.builder()
                .serverUrl(auth_server_url)
                .realm(master_realm)
                .username(master_username)
                .password(master_password)
                .clientId(master_client_id)
                .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build())
                .build();
    }


}

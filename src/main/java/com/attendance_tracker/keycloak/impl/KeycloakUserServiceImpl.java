package com.attendance_tracker.keycloak.impl;

import com.attendance_tracker.keycloak.KeycloakApiMasterRealmClient;
import com.attendance_tracker.keycloak.KeycloakApiRealmClient;
import com.attendance_tracker.keycloak.KeycloakUserService;
import com.attendance_tracker.keycloak.MockOwnerData;
import com.attendance_tracker.keycloak.model.KeycloakRealm;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeycloakUserServiceImpl implements KeycloakUserService {


    @Autowired
    private KeycloakApiMasterRealmClient masterRealmClient;

    @Autowired
    private KeycloakApiRealmClient realmClient;


    @Override
    public void init() {
        final KeycloakRealm keycloakRealm = masterRealmClient.saveRealm(MockOwnerData.createRealm(
                MockOwnerData.createRole("OWNER", false, null),
                Lists.newArrayList(MockOwnerData.createGroup(null, null, null)),
                Lists.newArrayList(MockOwnerData.createUser(null, null, null)),
                Lists.newArrayList(MockOwnerData.createClient())
        ));
    }
}

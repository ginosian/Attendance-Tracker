package com.attendance_tracker.rest.endpoint.impl;

import com.attendance_tracker.keycloak.KeycloakUserService;
import com.attendance_tracker.rest.endpoint.KeycloakEndpoint;
import org.springframework.beans.factory.annotation.Autowired;

public class KeycloakEndpointImpl implements KeycloakEndpoint {

    @Autowired
    private KeycloakUserService keycloakUserService;

    @Override
    public void init() {
        keycloakUserService.init();
    }
}

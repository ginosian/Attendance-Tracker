package com.attendance_tracker.keycloak;

        import com.attendance_tracker.keycloak.model.KeycloakRealm;
        import org.keycloak.admin.client.Keycloak;

        import java.util.List;

public interface KeycloakApiMasterRealmClient {

    Keycloak client();

    KeycloakRealm saveRealm(KeycloakRealm realmDto);

    KeycloakRealm getRealm(String id);

    List<KeycloakRealm> getAllRealms();
}

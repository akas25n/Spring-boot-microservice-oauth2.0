package com.userstorageprovider;

import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProviderFactory;

public class RemoteUserStorageProviderFactory implements UserStorageProviderFactory<RemoteUserStorageProvider> {

    private static final String PROVIDER_NAME = "my-user-storage-provider";

    @Override public RemoteUserStorageProvider create(KeycloakSession keycloakSession, ComponentModel componentModel) {
        return new RemoteUserStorageProvider(keycloakSession, componentModel);
    }

    @Override public String getId() {
        return PROVIDER_NAME;
    }
}

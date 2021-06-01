package com.userstorageprovider;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProviderFactory;

public class RemoteUserStorageProviderFactory implements UserStorageProviderFactory<RemoteUserStorageProvider> {

    private static final String PROVIDER_NAME = "my-user-storage-provider";

    @Override public RemoteUserStorageProvider create(KeycloakSession keycloakSession, ComponentModel componentModel) {
        return new RemoteUserStorageProvider(
            keycloakSession, componentModel, buildClient("http://localhost:8091"));
    }

    @Override public String getId() {
        return PROVIDER_NAME;
    }

    private UserApiService buildClient(String uri){
        ResteasyClient resteasyClient = new ResteasyClientBuilder().build();
        ResteasyWebTarget webTarget = resteasyClient.target(uri);

        return webTarget.proxyBuilder(UserApiService.class)
            .classloader(UserApiService.class.getClassLoader()).build();
    }
}

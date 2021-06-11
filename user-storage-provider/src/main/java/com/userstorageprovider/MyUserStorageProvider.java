package com.userstorageprovider;

import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialInputValidator;
import org.keycloak.credential.UserCredentialStore;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;
import org.keycloak.models.credential.PasswordCredentialModel;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.adapter.AbstractUserAdapter;
import org.keycloak.storage.user.UserLookupProvider;

public class MyUserStorageProvider implements org.keycloak.storage.UserStorageProvider, UserLookupProvider, CredentialInputValidator {

    private KeycloakSession keycloakSession;
    private ComponentModel componentModel;
    private UserApiService userApiService;

    public MyUserStorageProvider(KeycloakSession keycloakSession, ComponentModel componentModel, UserApiService userApiService) {
        this.keycloakSession = keycloakSession;
        this.componentModel = componentModel;
        this.userApiService = userApiService;
    }

    @Override
    public void close() {

    }

    @Override public UserModel getUserById(String id, RealmModel realmModel) {

        StorageId s_id = new StorageId(id);
        String userName = s_id.getExternalId();

        return getUserByUsername(userName, realmModel);
    }

    @Override public UserModel getUserByUsername(String userName, RealmModel realmModel) {
        UserModel userModel = null;

        RemoteUser user = userApiService.getUserDetails(userName);
        if (user != null){
            userModel = createUserModel(userName, realmModel);
        }
        return userModel;
    }

    @Override public UserModel getUserByEmail(String email, RealmModel realmModel) {
        return null;
    }

    private UserModel createUserModel(String username, RealmModel realmModel){
        return new AbstractUserAdapter(keycloakSession,realmModel, componentModel){

            @Override public String getUsername() {
                return username;
            }
        };
    }

    @Override public boolean supportsCredentialType(String passwordCredentialType) {
        return PasswordCredentialModel.TYPE.equals(passwordCredentialType);
    }

    @Override public boolean isConfiguredFor(RealmModel realmModel, UserModel userModel, String passwordCredentialType) {
        if (!supportsCredentialType(passwordCredentialType)){
            return false;
        }
        return !getUserCredentialStore()
            .getStoredCredentialsByType(realmModel, userModel, passwordCredentialType).isEmpty();
    }

    private UserCredentialStore getUserCredentialStore(){
        return keycloakSession.userCredentialManager();
    }

    @Override public boolean isValid(RealmModel realmModel, UserModel userModel, CredentialInput credentialInput) {
        VerifyUserPasswordResponse verifyPasswordResponse = userApiService.verifyPassword(userModel.getUsername(),
            credentialInput.getChallengeResponse());

        if (verifyPasswordResponse == null){
            return false;
        }
        return verifyPasswordResponse.getStatus();
    }
}

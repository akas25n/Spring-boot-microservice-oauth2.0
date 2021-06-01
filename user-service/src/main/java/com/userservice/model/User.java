package com.userservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 5313493413859894403L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userId;
    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userEmailVerificationToken;
    private String encryptedPassword;
    private boolean emailVerificationStatus;

    public User() {
    }

    public User(long id, String userId, String userFirstName, String userLastName,
        String userEmail, String userEmailVerificationToken, String encryptedPassword,
        boolean emailVerificationStatus) {
        this.id = id;
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userEmailVerificationToken = userEmailVerificationToken;
        this.encryptedPassword = encryptedPassword;
        this.emailVerificationStatus = emailVerificationStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmailVerificationToken() {
        return userEmailVerificationToken;
    }

    public void setUserEmailVerificationToken(String userEmailVerificationToken) {
        this.userEmailVerificationToken = userEmailVerificationToken;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public boolean isEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }
}

package com.userstorageprovider;

public class RemoteUser {

    private String userId;
    private String userFirstName;
    private String userLastName;
    private String UserEmail;
    private String userName;

    public RemoteUser() {
    }

    public RemoteUser(String userId, String userFirstName, String userLastName, String userEmail, String userName) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        UserEmail = userEmail;
        this.userName = userName;
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
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

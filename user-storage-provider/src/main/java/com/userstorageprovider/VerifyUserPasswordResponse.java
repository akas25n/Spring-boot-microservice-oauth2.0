package com.userstorageprovider;

public class VerifyUserPasswordResponse {

    private boolean status;

    public VerifyUserPasswordResponse() {
    }

    public VerifyUserPasswordResponse(boolean result) {
        this.status = result;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

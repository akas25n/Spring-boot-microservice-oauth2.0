package com.userstorageprovider;

public class VerifyUserPasswordResponse {

    private boolean result;

    public VerifyUserPasswordResponse() {
    }

    public VerifyUserPasswordResponse(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}

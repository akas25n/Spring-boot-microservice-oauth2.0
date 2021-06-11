package com.userservice.response;

public class VerifyUserPasswordResponse {

    private boolean status;

    public VerifyUserPasswordResponse() {
    }

    public VerifyUserPasswordResponse(boolean result) {
        this.status = result;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

package com.api.models.request.payloads;

public class ForgotPassReqPayloads {

    String email;

    public ForgotPassReqPayloads(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

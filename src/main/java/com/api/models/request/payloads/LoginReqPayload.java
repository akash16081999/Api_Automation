package com.api.models.request.payloads;

public class LoginReqPayload {

    String username;
    String password;

    public LoginReqPayload(String username, String pass) {
        this.username = username;
        this.password = pass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginReqPayload{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

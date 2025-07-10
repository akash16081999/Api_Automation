package com.api.models.response.payloads;

import java.util.Arrays;
import java.util.List;

public class LoginResPayload {
    String token;
    String type;
    String id;
    String username;
    String email;
    List roles;

    public LoginResPayload() {

    }

    public LoginResPayload(String email, String id, List roles, String token, String type, String username) {
        this.email = email;
        this.id = id;
        this.roles = roles;
        this.token = token;
        this.type = type;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List getRoles() {
        return roles;
    }

    public void setRoles(List roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginResPayload{" +
                "email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}

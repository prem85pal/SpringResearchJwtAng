package com.auth;


public class UserLoginResponse {

    private final String token;

    public UserLoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

}

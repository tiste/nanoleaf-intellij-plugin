package com.github.tiste.nanoleafintellijplugin.services;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthTokenEntity {
    @JsonProperty("auth_token")
    private String authToken;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}

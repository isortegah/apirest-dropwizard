package com.isortegah.dtos.res.token;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author ISORTEGAH
 */
public class TokenResDTO {

    @JsonProperty
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

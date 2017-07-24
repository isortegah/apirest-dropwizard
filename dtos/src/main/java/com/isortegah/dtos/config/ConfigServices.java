package com.isortegah.dtos.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author isortegah
 */
public class ConfigServices {
    @JsonProperty
    private String secret;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}

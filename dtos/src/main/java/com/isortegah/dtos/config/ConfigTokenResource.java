package com.isortegah.dtos.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author ISORTEGAH
 */
public class ConfigTokenResource {
    
    @JsonProperty
    private String secret;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}

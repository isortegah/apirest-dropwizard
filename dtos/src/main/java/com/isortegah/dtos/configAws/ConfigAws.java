package com.isortegah.dtos.configAws;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author isortegah
 */
public class ConfigAws {

    @JsonProperty
    private String credentialProvider;

    public String getCredentialProvider() {
        return credentialProvider;
    }

    public void setCredentialProvider(String credentialProvider) {
        this.credentialProvider = credentialProvider;
    }
    
}

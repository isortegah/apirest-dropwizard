package com.isortegah.dtos.configAws;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author isortegah
 */
public class ConfigAws {

    @JsonProperty
    private String credentialProvider;

    @JsonProperty
    private String region;

    public String getRegion() { return region; }

    public void setRegion(String region) { this.region = region; }

    public String getCredentialProvider() { return credentialProvider; }

    public void setCredentialProvider(String credentialProvider) {
        this.credentialProvider = credentialProvider;
    }
    
}

package com.isortegah.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isortegah.dtos.configAws.ConfigAws;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 *
 * @author ISORTEGAH
 */
public class RestConfiguration extends Configuration{
    @NotEmpty
    @JsonProperty
    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    
    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;
    
    @JsonProperty
    private ConfigAws aws;

    public ConfigAws getAws() {
        return aws;
    }

    public void setAws(ConfigAws aws) {
        this.aws = aws;
    }
}

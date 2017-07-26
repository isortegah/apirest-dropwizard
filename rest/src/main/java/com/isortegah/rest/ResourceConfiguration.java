package com.isortegah.rest;

import com.isortegah.dtos.config.ConfigServices;
import com.isortegah.dtos.config.ConfigTokenResource;

/**
 *
 * @author ISORTEGAH
 */
public class ResourceConfiguration {

    private final ConfigServices config;

    ResourceConfiguration(ConfigServices configFromAws) {
        this.config = configFromAws;
    }

    public ConfigTokenResource getConfigTokenResource(){
        ConfigTokenResource conf = new ConfigTokenResource();
        conf.setSecret(config.getSecret());
        return conf;
    }
}

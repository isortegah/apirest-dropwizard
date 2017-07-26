package com.isortegah.rest.resources;

import com.codahale.metrics.health.HealthCheck;

/**
 *
 * @author ISORTEGAH
 */
public class AppHealthCheck extends HealthCheck {
    
    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }

}

package com.isortegah.rest;

import com.isortegah.aws.AwsS3;
import com.isortegah.dtos.configAws.ConfigAws;
import com.isortegah.rest.resources.VersionResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 *
 * @author ISORTEGAH
 */
public class ApiRestService extends Application<RestConfiguration>{
    
    public static void main(String[] args) throws Exception {
            new ApiRestService().run(args);
    }
    
    @Override
    public void initialize(Bootstrap<RestConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<RestConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(RestConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }           
        });
    }

    @Override
    public void run(RestConfiguration configuration,
                    Environment environment) {
        configFromAws( configuration.getAws() );
        environment.jersey().register(new VersionResource());
    }
    
    public void configFromAws( ConfigAws aws ){
        AwsS3 awsS3 = new AwsS3( aws.getCredentialProvider() );
        awsS3.getObjectBIS("configuraciones" , "apirestfullconfig.yml");
    }
    
}

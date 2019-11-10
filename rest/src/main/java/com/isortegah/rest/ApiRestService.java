package com.isortegah.rest;

import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.isortegah.aws.AwsS3;
import com.isortegah.dtos.config.ConfigServices;
import com.isortegah.dtos.configAws.ConfigAws;
import com.isortegah.rest.resources.AppHealthCheck;
import com.isortegah.rest.resources.TokenResource;
import com.isortegah.rest.resources.VersionResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author ISORTEGAH
 */
public class ApiRestService extends Application<RestConfiguration>{
    
    private static final Logger log = LogManager.getLogger("ApiRestService");
    
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
        ResourceConfiguration config = 
                new ResourceConfiguration(configFromAws( configuration.getAws() ));
        environment.healthChecks().register("app", new AppHealthCheck());
        environment.jersey().register( new VersionResource() );
        environment.jersey().register( new TokenResource( config.getConfigTokenResource() ));
    }
    
    public ConfigServices configFromAws( ConfigAws aws ){
        try {
            AwsS3 awsS3 = new AwsS3(aws);
            S3ObjectInputStream f = awsS3.getObjectBIS("configuraciones" , "apirestfullconfig.yml");
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            return mapper.readValue( f  , ConfigServices.class );
        } catch (IOException ex) {
            log.error( ex );
        }
        return null;
    }
    
}

package com.isortegah.rest;

import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.isortegah.aws.AwsS3;
import com.isortegah.dtos.config.ConfigServices;
import com.isortegah.dtos.configAws.ConfigAws;
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
    private ConfigServices config;
    
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
        try {
        AwsS3 awsS3 = new AwsS3( aws.getCredentialProvider() );
        S3ObjectInputStream f = awsS3.getObjectBIS("configuraciones" , "apirestfullconfig.yml");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        config = mapper.readValue( f  , ConfigServices.class );
        } catch (IOException ex) {
            log.error( ex );
        }
    }
    
}

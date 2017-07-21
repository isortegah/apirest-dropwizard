package com.isortegah.aws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author isortegah
 */
public class AwsCredentials {
    private static final Logger log = LogManager.getLogger("AwsCredentials");
    private String credentialProvider;

    public AwsCredentials( String credentialProvider) {
        setCredentialProvider(credentialProvider);
    }
    
    public String getCredentialProvider() {
        return credentialProvider;
    }

    public void setCredentialProvider(String credentialProvider) {
        this.credentialProvider = credentialProvider;
    }
    
    public void getCredentials(){
        log.info(credentialProvider);
    }
}

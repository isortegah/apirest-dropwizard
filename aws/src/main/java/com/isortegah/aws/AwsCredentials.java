package com.isortegah.aws;

import com.amazonaws.auth.AWSCredentials;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
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
    
    public AWSCredentials getCredentials(){
        AWSCredentials credentials = null ;
        switch( credentialProvider ){
            case "File":
                credentials = credentialForFile();
            break;
            default:
            break;
        }
        return credentials;
    }

    private AWSCredentials credentialForFile() {
        return new ProfileCredentialsProvider().getCredentials();
    }
}

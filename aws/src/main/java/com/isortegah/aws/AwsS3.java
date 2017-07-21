package com.isortegah.aws;

/**
 *
 * @author isortegah
 */
public class AwsS3 {

    AwsCredentials awsCredentials;
    public AwsS3(String credentialProvider) {
        awsCredentials = new AwsCredentials(credentialProvider);
        awsCredentials.getCredentials();
    }
    
}

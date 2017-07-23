package com.isortegah.aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author isortegah
 */
public class AwsS3 {

    private static final Logger log = LogManager.getLogger("AwsS3");
    private final AwsCredentials awsCredentials;
    private AmazonS3 s3Client;

    public AwsS3(String credentialProvider) {
        awsCredentials = new AwsCredentials( credentialProvider );
        setS3Client( new AmazonS3Client( awsCredentials.getCredentials() ) );
    }
    
    private AmazonS3 getS3Client() {
        return s3Client;
    }

    private void setS3Client(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }
    
    /**
     * Devuelve el inputStream del file obtenido desde aws 
     * 
     * @param bucket
     * @param file 
     * @return  
     * 
     */
    public S3ObjectInputStream getObjectBIS( String bucket , String file ) {
        try{
        S3Object obj = getS3Client().getObject( bucket , file );
        S3ObjectInputStream s3is = obj.getObjectContent();
        return s3is;
        } catch (AmazonServiceException e) {
            log.error(e.getErrorMessage());
        }
        return null;
    }
    
    
    
}

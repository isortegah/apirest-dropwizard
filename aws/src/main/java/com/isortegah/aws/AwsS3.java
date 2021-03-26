package com.isortegah.aws;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.regions.Regions;
import com.isortegah.dtos.configAws.ConfigAws;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author isortegah
 */
public class AwsS3 {

    private static final Logger log = LogManager.getLogger("AwsS3");
    private AmazonS3 s3Client;
    @Deprecated
    private AwsCredentials awsCredentials;

    @Deprecated
    public AwsS3(String credentialProvider) {
        awsCredentials = new AwsCredentials( credentialProvider );
        setS3Client( new AmazonS3Client( awsCredentials.getCredentials() ) );
    }

    public AwsS3(ConfigAws aws){
        setS3Client(AmazonS3ClientBuilder.standard().withRegion(getRegion(aws.getRegion())).build());
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

    private Regions getRegion(String region) {
        switch (region) {
            case "US_EAST_1":
                return Regions.US_EAST_1;
            case "GovCloud":
                return Regions.GovCloud;
            case "US_GOV_EAST_1":
                return Regions.US_GOV_EAST_1;
            case "US_EAST_2":
                return Regions.US_EAST_2;
            case "US_WEST_1":
                return Regions.US_WEST_1;
            case "US_WEST_2":
                return Regions.US_WEST_2;
            case "EU_WEST_1":
                return Regions.EU_WEST_1;
            case "EU_WEST_2":
                return Regions.EU_WEST_2;
            case "EU_WEST_3":
                return Regions.EU_WEST_3;
            case "EU_CENTRAL_1":
                return Regions.EU_CENTRAL_1;
            case "EU_NORTH_1":
                return Regions.EU_NORTH_1;
            case "AP_EAST_1":
                return Regions.AP_EAST_1;
            case "AP_SOUTH_1":
                return Regions.AP_SOUTH_1;
            case "AP_SOUTHEAST_1":
                return Regions.AP_SOUTHEAST_1;
            case "AP_SOUTHEAST_2":
                return Regions.AP_SOUTHEAST_2;
            case "AP_NORTHEAST_1":
                return Regions.AP_NORTHEAST_1;
            case "AP_NORTHEAST_2":
                return Regions.AP_NORTHEAST_2;
            case "SA_EAST_1":
                return Regions.SA_EAST_1;
            case "CN_NORTH_1":
                return Regions.CN_NORTH_1;
            case "CN_NORTHWEST_1":
                return Regions.CN_NORTHWEST_1;
            case "CA_CENTRAL_1":
                return Regions.CA_CENTRAL_1;
            case "ME_SOUTH_1":
                return Regions.ME_SOUTH_1;
            default: return Regions.DEFAULT_REGION;
        }
    }
    
    
}

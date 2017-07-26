package com.isortegah.authentication;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author ISORTEGAH
 */
public final class Token {

    private static final Logger log = LogManager.getLogger("Token");
    private String secret;

    public String getSecret() {
        return secret;
    }

    /**
     *
     * @param secret
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }
    
    public Token(String secret) {
        setSecret(secret);
    }

    public void generateToken() {
        
    }
}

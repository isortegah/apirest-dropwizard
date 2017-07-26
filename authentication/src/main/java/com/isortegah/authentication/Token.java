package com.isortegah.authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
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

    public String generateToken() {
        try{
            Algorithm algorithm = Algorithm.HMAC256(getSecret());
            String token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
            return token;
        } catch (IllegalArgumentException ex) {
            java.util.logging.Logger.getLogger(Token.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(Token.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

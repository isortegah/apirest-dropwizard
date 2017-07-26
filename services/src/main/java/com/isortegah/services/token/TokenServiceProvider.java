package com.isortegah.services.token;

import com.isortegah.authentication.Token;
import com.isortegah.dtos.config.ConfigTokenResource;
import com.isortegah.dtos.res.token.TokenResDTO;

/**
 *
 * @author ISORTEGAH
 */
public class TokenServiceProvider {

    private final Token token;

    

    public TokenServiceProvider(ConfigTokenResource config) {
        token = new Token( config.getSecret() );
    }
    
    public TokenResDTO getTokenJWT(){
        TokenResDTO tokenRes = new TokenResDTO();
        tokenRes.setToken(token.generateToken());
        return tokenRes;
    }
    
    public Token getToken() {
        return token;
    }
}

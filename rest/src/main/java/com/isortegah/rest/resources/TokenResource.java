package com.isortegah.rest.resources;

import com.isortegah.dtos.config.ConfigTokenResource;
import com.isortegah.services.token.TokenServiceProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author ISORTEGAH
 */
@Path("/token")
@Api( value = "/token")
@Produces(MediaType.APPLICATION_JSON)
public class TokenResource {

    private static final Logger log = LogManager.getLogger("TokenResource");
    private final ConfigTokenResource config;
    private TokenServiceProvider tokenSP;
    
    public TokenResource(ConfigTokenResource configTokenResource) {
        config = configTokenResource;
    }
    
    @POST
    @ApiOperation( value = "Solicita token de autenticación" ,notes="",  position = 0)
    public Response solicitaToken(){
        tokenSP = new TokenServiceProvider( config );
        return Response.status(Response.Status.CREATED)
                .entity(tokenSP.getTokenJWT()).build();
    }
    
}

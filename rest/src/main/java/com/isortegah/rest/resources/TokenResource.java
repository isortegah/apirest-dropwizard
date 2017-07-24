package com.isortegah.rest.resources;

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
    
    public TokenResource() {
    }
    
    @POST
    @Path("/")
    @ApiOperation( value = "Solicita token de autenticación" ,  position = 0)
    public Response solicitaToken(){
        return Response.status(Response.Status.CREATED).build();
    }
    
}

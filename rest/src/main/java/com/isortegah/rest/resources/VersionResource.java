package com.isortegah.rest.resources;

import com.codahale.metrics.annotation.Timed;
import com.isortegah.dtos.res.version.VersionDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author ISORTEGAH
 */
@Path("/version")
@Api(value = "/version")
@Produces(MediaType.APPLICATION_JSON)
public class VersionResource {
    private static final Logger log = LogManager.getLogger("VersionResource");
    @GET
    @Timed
    @ApiOperation(value = "Obtiene la información de la versión", notes="", position = 0)
    public VersionDTO version() {
    
       return new VersionDTO();
       
    }
}

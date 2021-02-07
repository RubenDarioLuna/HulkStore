package com.hulkstore.services.implemetantion;

import com.hulkstore.services.contracts.IAdministratorService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static java.util.Collections.singletonMap;

@Path( "/administrator" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class AdministratorService extends BaseApplicationService implements IAdministratorService
{
    @POST
    @Path( "/product/add" )
    public Response addProduct( @Context HttpServletRequest request )
    {
        Map<String, String> response = singletonMap( "message",
                                                     "Building Web Services with Java EE 8.");
        return Response.ok(response).build();
    }
}

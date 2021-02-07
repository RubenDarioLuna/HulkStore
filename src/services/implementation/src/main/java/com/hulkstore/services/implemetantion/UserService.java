package com.hulkstore.services.implemetantion;

import com.hulkstore.services.contracts.IUserService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;
import static java.util.Collections.singletonMap;


@Path( "/user" )
@Produces( MediaType.APPLICATION_JSON )
@Consumes( MediaType.APPLICATION_JSON )
public class UserService extends BaseApplicationService implements IUserService
{
    @GET
    @Path( "test" )
    public Response helloWorld() {
        Map<String, String> response = singletonMap("message",
                                                    "Building Web Services with Java EE 8.");
        return Response.ok(response).build();
    }
}

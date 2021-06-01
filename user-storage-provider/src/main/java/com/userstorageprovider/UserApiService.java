package com.userstorageprovider;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
public interface UserApiService {

    @GET
    @Path("/{email}")
    User getUserDetails(@PathParam("email") String email);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{email}/password-verify")
    VerifyUserPasswordResponse verifyPassword(@PathParam("email") String email, String password);
}

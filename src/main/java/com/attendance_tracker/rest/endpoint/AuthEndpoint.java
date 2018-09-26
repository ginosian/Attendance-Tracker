package com.attendance_tracker.rest.endpoint;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("auth/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AuthEndpoint {

    @POST
    @Path("/register")
    void register();

    @POST
    @Path("/logout")
    void logout();
}

package com.attendance_tracker.rest.endpoint;

import org.springframework.security.access.prepost.PreAuthorize;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/logout")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface LogoutEndpoint {

    @POST
    @Path("")
    @PreAuthorize("permitAll()")
    void logout();
}

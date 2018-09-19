package com.attendance_tracker.rest.endpoint;


import com.attendance_tracker.rest.endpoint.dto.InfoDto;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/owner")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface OwnerEndpoint {

    @GET
    @Path("")
    @PreAuthorize("hasRole('OWNER')")
    InfoDto owner();
}

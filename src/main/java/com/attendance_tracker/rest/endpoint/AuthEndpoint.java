package com.attendance_tracker.rest.endpoint;

import com.attendance_tracker.rest.endpoint.dto.AuthRequestDto;
import com.attendance_tracker.rest.endpoint.dto.AuthResponseDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface AuthEndpoint {

    @POST
    @Path("/login")
    AuthResponseDto login(final AuthRequestDto requestDto);
}

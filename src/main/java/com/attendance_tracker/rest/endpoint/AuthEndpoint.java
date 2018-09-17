package com.attendance_tracker.rest.endpoint;

import com.attendance_tracker.rest.endpoint.dto.AuthRequestDto;
import com.attendance_tracker.rest.endpoint.dto.AuthResponseDto;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

public interface AuthEndpoint {

    @POST
    @Path("/login")
    AuthResponseDto login(final AuthRequestDto requestDto);
}

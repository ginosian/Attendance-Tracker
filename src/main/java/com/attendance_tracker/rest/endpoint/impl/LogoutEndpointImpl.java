package com.attendance_tracker.rest.endpoint.impl;

import com.attendance_tracker.facade.authentication.AuthenticationFacade;
import com.attendance_tracker.rest.endpoint.LogoutEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

@Component
public class LogoutEndpointImpl implements LogoutEndpoint {

    @Autowired
    private AuthenticationFacade authenticationFacade;

    @Context
    private HttpServletRequest request;

    @Override
    public void logout() {
        final String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            return;
        } else {
            final String token = header.replaceAll("Bearer ", "");
            authenticationFacade.logout(token);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
    }
}

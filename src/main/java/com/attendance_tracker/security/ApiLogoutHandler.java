package com.attendance_tracker.security;

import com.attendance_tracker.facade.authentication.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ApiLogoutHandler implements LogoutHandler {

    private AuthenticationFacade authenticationFacade;

    @Autowired
    public ApiLogoutHandler(final AuthenticationFacade authenticationFacade) {
        this.authenticationFacade = authenticationFacade;
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        final String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            return;
        } else {
            final String token = header.replaceAll("Bearer ", "");
            authenticationFacade.logout(token);
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }
}

package com.attendance_tracker.security.jwt;

import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.facade.authentication.AuthenticationFacade;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private AuthenticationFacade authenticationFacade;

    public JWTAuthorizationFilter(AuthenticationFacade authenticationManager) {
        super(authenticationManager);
        this.authenticationFacade = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {
        final String header = req.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }
        final UsernamePasswordAuthenticationToken authentication = getAuthentication(header);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(final String header) {
        final String token = header.replaceAll("Bearer ", "");
        final ApiAuthAccessToken existingToken = authenticationFacade.authenticateByApiAccessToken(token);
        return new UsernamePasswordAuthenticationToken(existingToken.getApiUserDetail(), existingToken.getToken(), existingToken.getApiUserDetail().getAuthorities());
    }
}

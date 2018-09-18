package com.attendance_tracker.security.jwt;

import com.attendance_tracker.facade.authentication.AuthenticationFacade;
import com.attendance_tracker.facade.authentication.exception.AuthException;
import com.attendance_tracker.facade.authentication.model.AuthenticationRequest;
import com.attendance_tracker.facade.authentication.model.AuthenticationResponse;
import com.attendance_tracker.mapper.BeanMapper;
import com.attendance_tracker.rest.endpoint.dto.AuthRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter  extends UsernamePasswordAuthenticationFilter {

    private AuthenticationFacade authenticationFacade;
    private BeanMapper beanMapper;

    @Autowired
    public JwtAuthenticationFilter(final AuthenticationFacade authenticationFacade, final BeanMapper beanMapper) {
        this.authenticationFacade = authenticationFacade;
        this.beanMapper = beanMapper;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            final AuthRequestDto credentials = new ObjectMapper().readValue(req.getInputStream(), AuthRequestDto.class);
            final AuthenticationRequest authenticationRequest = beanMapper.map(credentials, AuthenticationRequest.class);
            final AuthenticationResponse authenticationResponse = authenticationFacade.authenticateByCredentials(authenticationRequest);
            return new UsernamePasswordAuthenticationToken(authenticationResponse.getApiUserDetail(), authenticationResponse.getToken());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (AuthException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        String token = (String)auth.getCredentials();
        res.addHeader("Authorization", "Bearer " + token);
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

}

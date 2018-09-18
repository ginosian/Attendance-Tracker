package com.attendance_tracker.security.jwt;

import com.attendance_tracker.security.AuthorityDetails;
import com.attendance_tracker.service.token.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

public class JwtAuthenticationTokenFilter{

    private final static Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Autowired
    private TokenService tokenService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    @Qualifier("api_user_detail_service")
    private UserDetailsService userDetailsService;

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            Optional<String> tokenValue = jwtTokenService.getToken(request);
            tokenValue.ifPresent(token -> {
                final String username = tokenService.getUsernameFromToken(token);
                hasText(username, "username from token can not be null or empty");
                final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                notNull(userDetails, "user_detail details was not fount by username.");
                final AuthorityDetails authorityDetails = new AuthorityDetails(userDetails, token);
                SecurityContextHolder.getContext().setAuthentication(authorityDetails);
            });
            chain.doFilter(request, response);
        }
    }
}
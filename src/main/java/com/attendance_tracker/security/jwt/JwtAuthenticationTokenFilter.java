package com.attendance_tracker.security.jwt;

import com.attendance_tracker.security.AuthorityDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private final static Logger logger = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            Optional<String> tokenValue = jwtTokenService.getTokenValue(request);
            tokenValue.ifPresent(token -> {
                final String username = jwtTokenService.getUsernameValueFromToken(token);
                hasText(username, "username from token can not be null or empty");
                final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                notNull(userDetails, "user details was not fount by username.");
                final AuthorityDetails authorityDetails = new AuthorityDetails(userDetails, token);
                SecurityContextHolder.getContext().setAuthentication(authorityDetails);
            });
            chain.doFilter(request, response);
        }
    }
}
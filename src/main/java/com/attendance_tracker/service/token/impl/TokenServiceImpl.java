package com.attendance_tracker.service.token.impl;

import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.misc.TokenType;
import com.attendance_tracker.security.jwt.JwtTokenService;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenRefreshRequest;
import com.attendance_tracker.service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

@Service
@PropertySource("classpath:application-security.properties")
public class TokenServiceImpl implements TokenService {


    @Value("${security.jwt.expiration.seconds:3600}")
    private int AUTH_ACCESS_TOKEN_EXPIRATION_SECONDS;

    @Value("${security.jwt.calim.username:username}")
    private String CALIM_USERNAME;

    @Value("${security.jwt.calim.password:password}")
    private String CALIM_PASSWORD;

    @Value("${security.jwt.calim.created:created}")
    private String CALIM_CREATED;

    @Value("${security.jwt.calim.type:type}")
    private String CALIM_TYPE;

    @Value("${security.jwt.calim.active:active}")
    private String CALIM_ACTIVE;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Override
    public String createNewToken(final ApiAuthAccessTokenCreationRequest request) {
        notNull(request, "request can not be null.");
        final APIUserDetail userDetail = request.getUserDetail();
        final TokenType tokenType = request.getTokenType();
        final String username = userDetail.getUsername();
        final String passwordHash = userDetail.getPasswordHash();
        notNull(userDetail, "request.userDetail can not be null.");
        notNull(tokenType, "request.tokenType can not be null.");
        hasText(username, "request.userDetail.username can not be null or empty.");
        hasText(username, "request.userDetail.passwordHash can not be null or empty.");

        final Date creationDate =  new Date();
        final boolean isActive = request.isActive();

        final Map<String, Object> claims = new HashMap<>();
        claims.put(CALIM_USERNAME, username);
        claims.put(CALIM_PASSWORD, passwordHash);
        claims.put(CALIM_CREATED, creationDate);
        claims.put(CALIM_TYPE, tokenType);
        claims.put(CALIM_ACTIVE, isActive);

        final Date expirationDate = createExpirationDate(creationDate.getTime());

        return jwtTokenService.createToken(claims, expirationDate);
    }

    @Override
    public String refreshToken(final ApiAuthAccessTokenRefreshRequest request) {
        notNull(request, "request can not be null.");
        final Map<String, Object> claims = jwtTokenService.getClaims(request.getToken());
        claims.remove(CALIM_CREATED);
        final Date creationDate =  new Date();
        claims.put(CALIM_CREATED, creationDate);
        final Date expirationDate = createExpirationDate(creationDate.getTime());
        return jwtTokenService.createToken(claims, expirationDate);
    }

    @Override
    public String getUsernameFromToken(final String token) {
        hasText(token, "token can not be null or empty.");
        return jwtTokenService.getClaim(token, CALIM_USERNAME);
    }

    @Override
    public String getPasswordHashFromToken(final String token) {
        hasText(token, "token can not be null or empty.");
        return jwtTokenService.getClaim(token, CALIM_PASSWORD);
    }

    private Date createExpirationDate(final long time){
        return new Date(1000L * AUTH_ACCESS_TOKEN_EXPIRATION_SECONDS + time);
    }
}

package com.attendance_tracker.service.api_auth_access_token.impl;


import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.misc.TokenType;
import com.attendance_tracker.repository.ApiAuthAccessTokenRepository;
import com.attendance_tracker.service.api_auth_access_token.ApiAuthAccessTokenService;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenRefreshRequest;
import com.attendance_tracker.service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

@Service
@PropertySource("classpath:application-security.properties")
public class ApiAuthAccessTokenServiceImpl implements ApiAuthAccessTokenService {

    @Value("${security.jwt.expiration.seconds:3600}")
    private int AUTH_ACCESS_TOKEN_EXPIRATION_SECONDS;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ApiAuthAccessTokenRepository tokenRepository;

    @Override
    public Optional<ApiAuthAccessToken> findByUserDetail(final String userDetailId) {
        hasText(userDetailId, "userDetailId can not be null");
        return Optional.ofNullable(tokenRepository.findByUser(userDetailId));
    }

    @Override
    public Optional<ApiAuthAccessToken> findByApiAccessToken(final String token) {
        hasText(token, "token can not be null");
        return Optional.ofNullable(tokenRepository.findByToken(token));
    }

    @Override
    public ApiAuthAccessToken createApiAccessToken(final ApiAuthAccessTokenCreationRequest request) {
        notNull(request, "request can not be null");
        final APIUserDetail userDetail = request.getUserDetail();
        final TokenType tokenType = request.getTokenType();
        notNull(userDetail, "request.userDetailcan not be null");
        notNull(tokenType, "request.tokenType can not be null");

        final Date expires = createExpirationDate(new Date().getTime());
        request.setExpires(expires);
        final String token = tokenService.create(request);

        ApiAuthAccessToken apiAuthAccessToken = new ApiAuthAccessToken();
        apiAuthAccessToken.setToken(token);
        apiAuthAccessToken.setTokenType(tokenType);
        apiAuthAccessToken.setActive(true);
        apiAuthAccessToken.setApiUserDetail(userDetail);
        apiAuthAccessToken.setExpires(expires.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        return tokenRepository.save(apiAuthAccessToken);
    }

    @Override
    public ApiAuthAccessToken updateApiAccessToken(final ApiAuthAccessTokenRefreshRequest request) {
        notNull(request, "request can not be null");
        final ApiAuthAccessToken apiAuthAccessToken  = request.getToken();
        notNull(apiAuthAccessToken, "request.apiAuthAccessToken can not be null");

        final Date expires = createExpirationDate(new Date().getTime());
        final String refreshedToken = tokenService.refresh(apiAuthAccessToken.getToken(), expires);

        apiAuthAccessToken.setToken(refreshedToken);
        apiAuthAccessToken.setExpires(expires.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        return tokenRepository.save(apiAuthAccessToken);
    }

    @Override
    public void deleteApiAccessToken(final long apiAccessTokenId) {

    }

    @Override
    public List<ApiAuthAccessToken> getApiAccessTokens() {
        return null;
    }

    private Date createExpirationDate(final long time){
        return new Date(1000L * AUTH_ACCESS_TOKEN_EXPIRATION_SECONDS + time);
    }
}

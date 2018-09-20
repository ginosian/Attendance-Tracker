package com.attendance_tracker.service.api_auth_access_token.impl;

import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.misc.TokenType;
import com.attendance_tracker.repository.ApiAuthAccessTokenRepository;
import com.attendance_tracker.service.api_auth_access_token.ApiAuthAccessTokenConverter;
import com.attendance_tracker.service.api_auth_access_token.ApiAuthAccessTokenService;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenCreationRequest;
import com.attendance_tracker.service.api_auth_access_token.model.ApiAuthAccessTokenRequest;
import com.attendance_tracker.service.token.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import static org.springframework.util.Assert.hasText;
import static org.springframework.util.Assert.notNull;

@Service
@PropertySource("classpath:application-security.properties")
public class ApiAuthAccessTokenServiceImpl implements ApiAuthAccessTokenService {

    private static final Logger logger = LoggerFactory.getLogger(ApiAuthAccessTokenServiceImpl.class);

    @Value("${security.jwt.expiration.seconds:3600}")
    private int AUTH_ACCESS_TOKEN_EXPIRATION_SECONDS;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ApiAuthAccessTokenRepository tokenRepository;

    @Override
    public Optional<ApiAuthAccessToken> findByToken(final String token) {
        hasText(token, "token can not be null");
        return Optional.ofNullable(tokenRepository.findByToken(token));
    }

    @Override
    public Optional<ApiAuthAccessToken> findByUserDetailId(final String userDetailId) {
        hasText(userDetailId, "userDetailId can not be null");
        return Optional.ofNullable(tokenRepository.findByUser(userDetailId));
    }

    @Override
    public ApiAuthAccessToken createApiAccessToken(final ApiAuthAccessTokenCreationRequest request) {
        notNull(request, "request can not be null");
        final APIUserDetail userDetail = request.getUserDetail();
        final TokenType tokenType = request.getTokenType();
        notNull(userDetail, "request.userDetail can not be null");
        notNull(tokenType, "request.tokenType can not be null");

        final String userId = userDetail.getUser().getId();
        logger.debug("Creating apiAuthAccessToken for user:'{}'...", userId);
        final Date expires = createExpirationDate(new Date().getTime());
        request.setExpires(expires);
        final String token = tokenService.create(request);

        final ApiAuthAccessToken apiAuthAccessToken = tokenRepository.save(ApiAuthAccessTokenConverter.convert(request, token));
        logger.trace("ApiAuthAccessToken:'{}' is created for user:'{}'.", apiAuthAccessToken.getToken(), userId);
        return apiAuthAccessToken;
    }

    @Override
    public ApiAuthAccessToken refreshApiAccessToken(final ApiAuthAccessTokenRequest request) {
        notNull(request, "request can not be null");
        final ApiAuthAccessToken token  = request.getToken();
        notNull(token, "request.token can not be null");

        logger.debug("Refreshing token for user:'{}'...", token.getApiUserDetail().getUser().getId());
        token.setExpires(createExpirationDate(new Date().getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        token.setActive(true);
        logger.trace("ApiAuthAccessToken:'{}' is refreshed for user:'{}'.", token.getToken(), token.getApiUserDetail().getUser().getId());
        return tokenRepository.save(token);
    }

    @Override
    public ApiAuthAccessToken inactivateApiAccessToken(ApiAuthAccessTokenRequest request) {
        notNull(request, "request can not be null");
        final ApiAuthAccessToken apiAuthAccessToken  = request.getToken();
        notNull(apiAuthAccessToken, "request.apiAuthAccessToken can not be null");

        apiAuthAccessToken.setActive(false);
        return tokenRepository.save(apiAuthAccessToken);
    }

    private Date createExpirationDate(final long time){
        return new Date(1000L * AUTH_ACCESS_TOKEN_EXPIRATION_SECONDS + time);
    }
}

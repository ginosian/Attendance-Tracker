package com.attendance_tracker.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@PropertySource("classpath:application-security.properties")
public class JwtTokenService {

    private final static Logger logger = LoggerFactory.getLogger(JwtTokenService.class);
    private final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    @Value("${security.jwt.token.secret}")
    private String JWT_TOKEN_SECRET;

    @Value("${security.jwt.expiration.seconds:3600}")
    private int JWT_EXPIRATION_SECONDS = 3600;

    @Value("${security.jwt.header:Authorization}")
    private String JWT_HEADER;

    @Value("${security.jwt.cookie:SO_AUTH_TOKEN}")
    private String JWT_COOKIE;

    @Value("${security.jwt.calim.key.username:username}")
    private String JWT_CALIM_KEY_USERNAME;

    @Value("${security.jwt.calim.key.created:created}")
    private String JWT_CALIM_KEY_CREATED;

    private String authenticationHeaderValuePrefix = "Bearer ";

    public Map<String, Object> assembleWebClaims(final UserDetails userDetails) {
        final Map<String, Object> claims = new HashMap<>();
        final String username = userDetails.getUsername();
        claims.put(JWT_CALIM_KEY_USERNAME, username);
        return claims;
    }

    public String createToken(Map<String, Object> claimsMap, String signingKey, int expirationSecs) {
        final Date createdDate = (Date) claimsMap.computeIfAbsent(JWT_CALIM_KEY_CREATED, k -> getCurrentDate());
        final Date expirationDate = new Date(1000L * expirationSecs + createdDate.getTime());

        String encodedKey = TextCodec.BASE64.encode(signingKey);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claimsMap)
                .setExpiration(expirationDate)
                .signWith(signatureAlgorithm, encodedKey)
                .compact();
    }

    public String createWebToken(Map<String, Object> claimsMap) {
        return createToken(claimsMap, JWT_TOKEN_SECRET, JWT_EXPIRATION_SECONDS);
    }

    public Optional<String> getCookieValueByName(String name, HttpServletRequest request) {
        return request.getCookies() != null ? Stream.of(request.getCookies()).filter(c -> c.getName().equals(name))
                .map(Cookie::getValue).findFirst() : Optional.empty();
    }

    private Date getCurrentDate() {
        return new Date();
    }

    private Optional<String> getHeaderValueByName(String authenticationHeaderName, HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader(authenticationHeaderName))
                .map(header -> header.startsWith(authenticationHeaderValuePrefix)
                        ? header.substring(authenticationHeaderValuePrefix.length())
                        : header);
    }

    public Claims getClaimsFromToken(String signingKey, String token) {
        String encodedKey = TextCodec.BASE64.encode(signingKey);
        return Jwts.parser().setSigningKey(encodedKey).parseClaimsJws(token).getBody();
    }

    public String getClaimValueFromToken(Claims claims, String key) {
        return claims.get(key, String.class);
    }

    public Optional<String> getTokenValue(HttpServletRequest request) {
        return Optional.ofNullable(
                getHeaderValueByName(JWT_HEADER, request)
                        .orElseGet(() -> getCookieValueByName(JWT_COOKIE, request)
                                .orElse(null)));
    }


    public String getUsernameValueFromToken(String token) {
            Claims claims = getClaimsFromToken(JWT_TOKEN_SECRET, token);
            return getClaimValueFromToken(claims, JWT_CALIM_KEY_USERNAME);
    }

    public String refreshWebToken(String token) {
        String refreshedToken;
        final Claims claims = getClaimsFromToken(JWT_TOKEN_SECRET, token);
        claims.remove(JWT_CALIM_KEY_CREATED);
        refreshedToken = createWebToken(claims);
        return refreshedToken;
    }

    public void setWebTokenCookie(String token, HttpServletResponse response) {
        Cookie cookie = new Cookie(JWT_COOKIE, token);
        cookie.setMaxAge(JWT_EXPIRATION_SECONDS);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }
}

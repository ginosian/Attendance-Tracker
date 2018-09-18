package com.attendance_tracker.service.token;

import com.attendance_tracker.entity.ApiAuthAccessToken;
import com.attendance_tracker.service.token.exception.TokenServiceException;
import com.attendance_tracker.service.token.model.TokenCreationRequest;
import com.attendance_tracker.service.token.model.TokenExistenceCheckRequest;
import com.attendance_tracker.service.token.model.TokenMarkAsUsedRequest;

public interface TokenService {

    ApiAuthAccessToken createNewToken(TokenCreationRequest tokenCreationRequest);

    ApiAuthAccessToken getExistingToken(TokenExistenceCheckRequest tokenExistenceCheckRequest) throws TokenServiceException;

    ApiAuthAccessToken demarkTokenAsUsed(TokenMarkAsUsedRequest tokenDemarcationAsUsedRequest) throws TokenServiceException;
}

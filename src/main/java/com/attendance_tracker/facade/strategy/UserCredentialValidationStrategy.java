package com.attendance_tracker.facade.strategy;

import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.facade.authentication.PasswordHashHelperComponent;
import com.attendance_tracker.facade.authentication.exception.AuthException;
import com.attendance_tracker.facade.authentication.exception.AuthenticationException;
import com.attendance_tracker.facade.authentication.exception.AuthorizationException;
import com.attendance_tracker.service.notification.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCredentialValidationStrategy {

    private static final Logger logger = LoggerFactory.getLogger(UserCredentialValidationStrategy.class);

    @Autowired
    private PasswordHashHelperComponent passwordHashHelperComponent;

    @Autowired
    private NotificationService notificationService;

    public void validateForAuthentication(final APIUserDetail userDetail) throws AuthException {
        final String userId = userDetail.getUser().getId();
        final String username = userDetail.getUsername();
        final String plainPassword = userDetail.getPassword();

        if(!userDetail.isApproved()){
            notificationService.requestEmailVerification();
            logger.debug("Authentication failed for for user:'{}' as email:'{}' is not verified.", userId, username);
            throw new AuthorizationException();
        }

        logger.debug("Attempting authentication with password for user:'{}'...", userId);
        if(!passwordHashHelperComponent.isPasswordCorrect(plainPassword)){
            logger.debug("Password validation failed for user:'{}'.", userId);
            throw new AuthenticationException();
        }
        logger.trace("Password validation passed for user:'{}'.", userId);
    }
}

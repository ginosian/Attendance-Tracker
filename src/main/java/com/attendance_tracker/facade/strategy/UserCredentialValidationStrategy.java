package com.attendance_tracker.facade.strategy;

import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.facade.authentication.PasswordHashHelperComponent;
import com.attendance_tracker.facade.authentication.exception.AuthenticationException;
import com.attendance_tracker.facade.authentication.exception.AuthorizationException;
import com.attendance_tracker.service.notification.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.Validate.notNull;
import static org.springframework.util.Assert.hasText;

@Component
public class UserCredentialValidationStrategy {

    private static final Logger logger = LoggerFactory.getLogger(UserCredentialValidationStrategy.class);

    @Autowired
    private PasswordHashHelperComponent passwordHashHelperComponent;

    @Autowired
    private NotificationService notificationService;

    public void validateForAuthentication(final APIUserDetail userDetail){
        notNull(userDetail, "userDetail can not be null");
        final String userId = userDetail.getUser().getId();
        final String username = userDetail.getUsername();
        final String plainPassword = userDetail.getPassword();
        hasText(userId, "userDetail.userId can not be null or empty.");
        hasText(username, "userDetail.username can not be null or empty.");
        hasText(plainPassword, "userDetail.plainPassword can not be null or empty.");

        if(!userDetail.getApproved()){
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

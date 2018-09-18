package com.attendance_tracker.service.authentication;


import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordHashHelperComponent {

    private static final int LOG_ROUNDS = 12;

    public Boolean isPasswordCorrect(String plainPassword) {
        return BCrypt.checkpw(plainPassword, hashPassword(plainPassword));
    }

    private String hashPassword(String plainPassword) {
        String salt = BCrypt.gensalt(LOG_ROUNDS);
        return BCrypt.hashpw(plainPassword, salt);
    }
}

package com.attendance_tracker.service.authentication.model;

import com.attendance_tracker.entity.User;

import java.time.LocalDateTime;

public class AuthenticationResponse {

    private User user;
    private String token;
    private LocalDateTime tokenExpirationDate;
}

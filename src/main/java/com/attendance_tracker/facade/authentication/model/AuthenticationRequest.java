package com.attendance_tracker.facade.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest{
    private String username;
    private String plainPassword;
    private boolean rememberMe;
}

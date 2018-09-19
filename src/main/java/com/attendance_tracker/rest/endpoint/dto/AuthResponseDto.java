package com.attendance_tracker.rest.endpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseDto {
    private String userId;
    private String token;
    private LocalDateTime tokenExpirationDate;
}

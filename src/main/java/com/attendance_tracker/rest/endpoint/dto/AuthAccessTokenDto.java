package com.attendance_tracker.rest.endpoint.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthAccessTokenDto {
    private String token;
    private AuthorityDto principal;
}

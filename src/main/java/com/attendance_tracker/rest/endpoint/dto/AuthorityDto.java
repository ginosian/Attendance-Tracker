package com.attendance_tracker.rest.endpoint.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityDto {
    private String username;
    private Set<RoleDto> roles;
    private String userId;
}

package com.attendance_tracker.rest.endpoint.dto;

import com.attendance_tracker.misc.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private RoleType role;
    private Set<PermissionDto> permissions;
}

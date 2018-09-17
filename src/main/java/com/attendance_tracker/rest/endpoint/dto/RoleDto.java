package com.attendance_tracker.rest.endpoint.dto;

import com.attendance_tracker.misc.RoleType;

import java.util.Set;

public class RoleDto {

    private RoleType role;

    private Set<PermissionDto> permissions;

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public Set<PermissionDto> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionDto> permissions) {
        this.permissions = permissions;
    }
}

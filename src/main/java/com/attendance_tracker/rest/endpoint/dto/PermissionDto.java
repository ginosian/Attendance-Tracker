package com.attendance_tracker.rest.endpoint.dto;

import com.attendance_tracker.misc.PermissionType;

public class PermissionDto {

    private PermissionType permissionType;

    public PermissionType getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(PermissionType permissionType) {
        this.permissionType = permissionType;
    }
}

package com.attendance_tracker.rest.endpoint.dto;

import com.attendance_tracker.misc.PermissionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDto {
    private PermissionType permissionType;
}

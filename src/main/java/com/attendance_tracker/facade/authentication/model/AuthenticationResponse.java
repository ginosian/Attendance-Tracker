package com.attendance_tracker.facade.authentication.model;

import com.attendance_tracker.entity.APIUserDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse{
    private APIUserDetail apiUserDetail;
    private String token;
}

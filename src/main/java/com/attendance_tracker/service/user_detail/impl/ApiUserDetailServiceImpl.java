package com.attendance_tracker.service.user_detail.impl;

import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.entity.User;
import com.attendance_tracker.service.user_detail.ApiUserDetailService;
import com.attendance_tracker.service.user_detail.model.ChangePasswordRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApiUserDetailServiceImpl implements ApiUserDetailService {

    @Override
    public APIUserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public APIUserDetail changePassword(ChangePasswordRequest changePasswordRequest) {
        return null;
    }

    @Override
    public APIUserDetail changePassword(String userId, String newPassword) {
        return null;
    }

    @Override
    public APIUserDetail changeEmail(String userId, String newEmail) {
        return null;
    }

    @Override
    public boolean isEmailUsed(String email) {
        return false;
    }

    @Override
    public boolean isCorrectPassword(String userId, String password) {
        return false;
    }

    @Override
    public boolean isUserActive(User user) {
        return false;
    }
}

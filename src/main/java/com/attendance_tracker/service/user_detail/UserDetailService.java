package com.attendance_tracker.service.user_detail;

import com.attendance_tracker.entity.APIUserDetail;
import com.attendance_tracker.entity.User;
import com.attendance_tracker.service.user_detail.impl.ChangePasswordRequest;

public interface UserDetailService {

    APIUserDetail getUserByEmail(String email);

    APIUserDetail changePassword(ChangePasswordRequest changePasswordRequest);

    APIUserDetail changePassword(String userId, String newPassword);

    APIUserDetail changeEmail(String userId, String newEmail);

    boolean isEmailUsed(String email);

    boolean isCorrectPassword(String userId, String password);

    boolean isUserActive(User user);

}

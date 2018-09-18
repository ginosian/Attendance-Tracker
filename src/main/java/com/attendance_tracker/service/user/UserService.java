package com.attendance_tracker.service.user;

import com.attendance_tracker.entity.User;
import com.attendance_tracker.service.user.model.UserCreateRequest;
import com.attendance_tracker.service.user.model.UserUpdateRequest;

import java.util.Optional;

public interface UserService {

    User get(String id);

    Optional<User> find(final String id);

    User create(UserCreateRequest userRequest);

    User update(String id, UserUpdateRequest userRequest);

    void delete(String id);

}

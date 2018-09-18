package com.attendance_tracker.service.user.impl;

import com.attendance_tracker.entity.User;
import com.attendance_tracker.service.user.UserService;
import com.attendance_tracker.service.user.model.UserCreateRequest;
import com.attendance_tracker.service.user.model.UserUpdateRequest;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Override
    public User get(String id) {
        return null;
    }

    @Override
    public Optional<User> find(String id) {
        return Optional.empty();
    }

    @Override
    public User create(UserCreateRequest userRequest) {
        return null;
    }

    @Override
    public User update(String id, UserUpdateRequest userRequest) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}

package com.attendance_tracker.service.user;

import com.attendance_tracker.entity.User;
import com.attendance_tracker.service.user.model.UserCreateRequest;
import com.attendance_tracker.service.user.model.UserUpdateRequest;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    User get(String id);

    Optional<User> find(final String id);

    User create(UserCreateRequest userRequest);

    User update(String id, UserUpdateRequest userRequest);

    // For lazy loading and filtering
    List<User> search(String filter, Pageable pageable);

    long countByFirstNameOrLastNameOrEmailOrCustomerName(String filter);

    Set<User> getUsersByCustomer(long customerId);

    void delete(String id);

}

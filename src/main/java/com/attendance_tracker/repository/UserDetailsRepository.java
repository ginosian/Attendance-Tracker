package com.attendance_tracker.repository;

import com.attendance_tracker.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {
}

package com.attendance_tracker.repository;

import com.attendance_tracker.entity.APIUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<APIUserDetails, String> {
}

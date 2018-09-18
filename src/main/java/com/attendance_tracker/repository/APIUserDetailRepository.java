package com.attendance_tracker.repository;

import com.attendance_tracker.entity.APIUserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APIUserDetailRepository extends JpaRepository<APIUserDetail, String> {

    APIUserDetail findByUsernameAndDeletedNull(String username);
}

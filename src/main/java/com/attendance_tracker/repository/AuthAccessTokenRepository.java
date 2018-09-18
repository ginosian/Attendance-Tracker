package com.attendance_tracker.repository;

import com.attendance_tracker.entity.ApiAuthAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthAccessTokenRepository extends JpaRepository<ApiAuthAccessToken, String> {
}

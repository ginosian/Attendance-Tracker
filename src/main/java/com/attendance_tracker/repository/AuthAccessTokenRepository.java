package com.attendance_tracker.repository;

import com.attendance_tracker.entity.AuthAccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthAccessTokenRepository extends JpaRepository<AuthAccessToken, String> {
}

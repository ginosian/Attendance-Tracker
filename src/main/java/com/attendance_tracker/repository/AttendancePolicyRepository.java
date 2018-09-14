package com.attendance_tracker.repository;

import com.attendance_tracker.entity.AttendancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendancePolicyRepository extends JpaRepository<AttendancePolicy, String> {
}

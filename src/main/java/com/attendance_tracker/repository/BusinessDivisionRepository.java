package com.attendance_tracker.repository;

import com.attendance_tracker.entity.BusinessDivision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessDivisionRepository extends JpaRepository<BusinessDivision, String> {
}

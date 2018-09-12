package com.attendance_tracker.repository;


import com.attendance_tracker.entity.CompanyDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, String> {
}

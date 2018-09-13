package com.attendance_tracker.repository;


import com.attendance_tracker.entity.BusinessDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDetailsRepository extends JpaRepository<BusinessDetails, String> {
}

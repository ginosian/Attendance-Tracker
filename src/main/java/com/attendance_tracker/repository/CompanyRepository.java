package com.attendance_tracker.repository;


import com.attendance_tracker.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Business, String> {
}

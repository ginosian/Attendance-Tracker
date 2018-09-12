package com.attendance_tracker.repository.integration;

import com.attendance_tracker.AbstractTestContext;
import com.attendance_tracker.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeRepositoryIntegrationTest  extends AbstractTestContext {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void saveSuccessful(){

    }

}
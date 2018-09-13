package com.attendance_tracker.repository;

import com.attendance_tracker.AbstractTest;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeRepositoryIntegrationTest extends AbstractTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}
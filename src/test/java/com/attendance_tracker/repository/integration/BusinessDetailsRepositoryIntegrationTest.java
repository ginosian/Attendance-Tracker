package com.attendance_tracker.repository.integration;

import com.attendance_tracker.AbstractTest;
import com.attendance_tracker.repository.CompanyDetailsRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class BusinessDetailsRepositoryIntegrationTest extends AbstractTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Autowired
    private CompanyDetailsRepository companyDetailsRepository;

    @Test
    public void test1(){
    }

}
package com.attendance_tracker.repository.integration;

import com.attendance_tracker.AbstractTestContext;
import com.attendance_tracker.repository.RoleRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class RoleRepositoryIntegrationTest extends AbstractTestContext {

    @Autowired
    private RoleRepository roleRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveSuccessful(){

    }
}
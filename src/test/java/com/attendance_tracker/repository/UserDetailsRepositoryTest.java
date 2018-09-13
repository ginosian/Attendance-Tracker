package com.attendance_tracker.repository;

import com.attendance_tracker.AbstractTest;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserDetailsRepositoryTest extends AbstractTest {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}
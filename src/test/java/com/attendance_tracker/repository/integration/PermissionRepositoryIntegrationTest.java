package com.attendance_tracker.repository.integration;

import com.attendance_tracker.AbstractTestContext;
import com.attendance_tracker.MockData;
import com.attendance_tracker.entity.Permission;
import com.attendance_tracker.repository.PermissionRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
public class PermissionRepositoryIntegrationTest extends AbstractTestContext {

    @Autowired
    private PermissionRepository permissionRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveSuccessful(){
        final List<Permission> permissions = permissionRepository.saveAll(MockData.createPermissions());
        assertNotNull(permissions);
    }

}
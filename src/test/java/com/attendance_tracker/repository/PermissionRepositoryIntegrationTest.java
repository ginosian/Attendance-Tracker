package com.attendance_tracker.repository;

import com.attendance_tracker.AbstractTest;
import com.attendance_tracker.MockData;
import com.attendance_tracker.entity.Permission;
import com.attendance_tracker.misc.PermissionType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class PermissionRepositoryIntegrationTest extends AbstractTest {

    @Autowired
    private PermissionRepository permissionRepository;

    private Permission permission;

    @Before
    public void setUp() throws Exception {
        permission = permissionRepository.save(MockData.createPermission(PermissionType.READ));
    }

    @After
    public void tearDown() throws Exception {
        permissionRepository.deleteAll();
    }

    @Test
    @DisplayName("Save successful.")
    public void test1(){
        final Permission permission = permissionRepository.save(MockData.createPermission(PermissionType.ALL));
        assertNotNull(permission);
    }

    @Test(expected = DataIntegrityViolationException.class)
    @DisplayName("Save fails when permission type is missing.")
    public void test2(){
        permissionRepository.save((MockData.createPermission(null)));
    }

    @Test(expected = DataIntegrityViolationException.class)
    @DisplayName("Save fails when duplicate type is persisted.")
    public void test3(){
        permissionRepository.save((MockData.createPermission(PermissionType.READ)));
    }

    @Test
    @DisplayName("Update successful.")
    public void test4(){
        permission.setType(PermissionType.ALL);
        final Permission updatedPermission = permissionRepository.save(permission);
        assertEquals(permission.getId(), updatedPermission.getId());
        assertEquals(permission.getType(), updatedPermission.getType());
    }

    @Test(expected = DataIntegrityViolationException.class)
    @DisplayName("Update fails when a null type is persisted.")
    public void test5(){
        permission.setType(null);
        permissionRepository.save(permission);
    }

    @Test
    @DisplayName("Delete successful")
    public void test6(){
        permissionRepository.delete(permission);
        assertNull(permissionRepository.findById(permission.getId()).orElse(null));
    }
}
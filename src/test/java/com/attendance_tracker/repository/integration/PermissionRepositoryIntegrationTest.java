package com.attendance_tracker.repository.integration;

import com.attendance_tracker.AbstractTest;
import com.attendance_tracker.MockData;
import com.attendance_tracker.entity.Permission;
import com.attendance_tracker.entity.Role;
import com.attendance_tracker.misc.PermissionType;
import com.attendance_tracker.misc.RoleType;
import com.attendance_tracker.repository.PermissionRepository;
import com.attendance_tracker.repository.RoleRepository;
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
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    private Permission permission;
    private Role role;

    @Before
    public void setUp() throws Exception {
        role = roleRepository.save(MockData.createRole(RoleType.OWNER));
        permission = MockData.createPermission(PermissionType.READ);
        permission = permissionRepository.save(permission);
    }

    @After
    public void tearDown() throws Exception {
        permissionRepository.deleteAll();
        roleRepository.deleteAll();
    }

    @Test
    @DisplayName("Create successful.")
    public void test1(){
        Permission permission = MockData.createPermission(PermissionType.ALL);
        permission = permissionRepository.save(permission);
        assertNotNull(permission);
    }

    @Test(expected = DataIntegrityViolationException.class)
    @DisplayName("Create fails when permission type is missing.")
    public void test2(){
        Permission permission = MockData.createPermission(null);
        permissionRepository.save(permission);
    }

    @Test(expected = DataIntegrityViolationException.class)
    @DisplayName("Create fails when duplicate type is persisted.")
    public void test3(){
        Permission permission = MockData.createPermission(PermissionType.READ);
        permissionRepository.save(permission);
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
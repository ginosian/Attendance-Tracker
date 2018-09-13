package com.attendance_tracker.repository.integration;

import com.attendance_tracker.AbstractTest;
import com.attendance_tracker.MockData;
import com.attendance_tracker.entity.Permission;
import com.attendance_tracker.entity.Role;
import com.attendance_tracker.misc.PermissionType;
import com.attendance_tracker.misc.RoleType;
import com.attendance_tracker.repository.PermissionRepository;
import com.attendance_tracker.repository.RoleRepository;
import com.google.common.collect.Sets;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class RoleRepositoryIntegrationTest extends AbstractTest {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    private Role role;
    private List<Permission> permissions;

    @Before
    public void setUp() throws Exception {
        permissions= permissionRepository.saveAll(MockData.createPermissions(PermissionType.ALL));
        role = roleRepository.save(MockData.createRole(RoleType.OWNER));
    }

    @After
    public void tearDown() throws Exception {
        roleRepository.deleteAll();
        permissionRepository.deleteAll();
    }

    @Test
    @DisplayName("Save successful.")
    public void test1(){
        final Role role = roleRepository.save(MockData.createRole(RoleType.COMPANY));
        assertNotNull(role);
    }

    @Test
    @DisplayName("Save successful with permissions.")
    public void test2(){
        Role role = MockData.createRole(RoleType.EMPLOYEE);
        role.setPermissions(Sets.newHashSet(permissions));
        role = roleRepository.save(role);
        assertTrue(role.getPermissions().size() > 0);
    }

    @Test(expected = DataIntegrityViolationException.class)
    @DisplayName("Save fails when role type is missing.")
    public void test3(){
        roleRepository.save(MockData.createRole(null));
    }

    @Test(expected = DataIntegrityViolationException.class)
    @DisplayName("Save fails when duplicate type is persisted.")
    public void test4(){
        roleRepository.save(MockData.createRole(RoleType.OWNER));
    }

    @Test
    @DisplayName("Update successful.")
    public void test5(){
        role.setType(RoleType.COMPANY_ADMIN);
        final Role updatedRole = roleRepository.save(role);
        assertEquals(role.getId(), updatedRole.getId());
        assertEquals(role.getType(), updatedRole.getType());
    }

    @Test
    @DisplayName("Update with permission successful.")
    public void test6(){
       role.setPermissions(Sets.newHashSet(permissions));
       role = roleRepository.save(role);
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    @DisplayName("Update of role with no permission ID fails.")
    public void test7(){
        role.setPermissions(Sets.newHashSet(
                permissions
                        .stream()
                        .peek(permission -> permission.setId(null))
                        .collect(Collectors.toSet())));
        roleRepository.save(role);
    }

    @Test(expected = DataIntegrityViolationException.class)
    @DisplayName("Update fails when a null type is persisted.")
    public void test8() {
        role.setType(null);
        roleRepository.save(role);
    }

    @Test
    @DisplayName("Delete of role permission successful")
    public void test9(){
        role.setPermissions(null);
        roleRepository.save(role);
        assertNull(role.getPermissions());
    }

    @Test
    @DisplayName("Delete successful")
    public void test10(){
        roleRepository.delete(role);
        assertNull(roleRepository.findById(role.getId()).orElse(null));
    }
}
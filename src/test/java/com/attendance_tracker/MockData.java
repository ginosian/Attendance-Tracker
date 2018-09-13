package com.attendance_tracker;

import com.attendance_tracker.entity.*;
import com.attendance_tracker.misc.PermissionType;
import com.attendance_tracker.misc.RoleType;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    // region Permission
    public static Permission createPermission(final PermissionType permissionType) {
        final Permission permission = new Permission();
        permission.setType(permissionType);
        return permission;
    }

    public static List<Permission> createPermissions(final PermissionType ... permissionTypes){
        final List<Permission> permissions = new ArrayList();
        for (PermissionType permissionType : permissionTypes) {
            final Permission permission = new Permission();
            permission.setType(permissionType);
            permissions.add(permission);
        }
        return permissions;
    }
    // endregion

    // region Role
    public static Role createRole(final RoleType roleType){
        final Role role = new Role();
        role.setType(roleType);
        return role;
    }
    // endregion

//    public static Business createTestCompany(){
//        final Business business = new Business();
//        business.setName("Test Business");
//        business.setEmail("business@business.com");
//        return business;
//    }
//
//    public static Employee createTestEmployee(){
//        final Employee employee = new Employee();
//        employee.setFirstName("Test employee");
//        employee.setEmail("employee@employee.com");
//        return employee;
//    }
//
//    public static Owner createOwner(){
//        final Owner owner = new Owner();
//        owner.setEmail("marta@marta.com");
//        return owner;
//    }

}

package com.attendance_tracker.listener;

import com.attendance_tracker.entity.Permission;
import com.attendance_tracker.entity.Role;
import com.attendance_tracker.misc.PermissionType;
import com.attendance_tracker.misc.RoleType;
import com.google.common.collect.Lists;

import java.util.List;

public class StaticData {

    public static List<Permission> createPermissions(){
        final Permission permissionAll = new Permission();
        permissionAll.setType(PermissionType.ALL);
        return Lists.newArrayList(permissionAll);
    }

    public static List<Role> createRoles(){
        final Role roleCompanyAdmin = new Role();
        roleCompanyAdmin.setType(RoleType.COMPANY_ADMIN);
        final Role roleEmployee = new Role();
        roleEmployee.setType(RoleType.EMPLOYEE);
        final Role roleCompany = new Role();
        roleCompany.setType(RoleType.COMPANY);
        final Role roleOwner = new Role();
        roleOwner.setType(RoleType.OWNER);
        return Lists.newArrayList(roleCompanyAdmin, roleCompany, roleEmployee, roleOwner);
    }
}

package com.attendance_tracker.listener;

import com.attendance_tracker.entity.*;
import com.attendance_tracker.repository.*;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApplicationEventListener {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @EventListener({ContextRefreshedEvent.class})
    public void onContextRefreshedEvent() {

        final List<Permission> permissions = permissionRepository.saveAll(StaticData.createPermissions());
        final List<Role> roles = roleRepository.saveAll(
                StaticData.createRoles()
                        .stream()
                        .peek(role -> role.setPermissions(Sets.newHashSet(permissions)))
                        .collect(Collectors.toSet()));

        final Company company = companyRepository.save(MockData.createTestCompany());
        final Employee employee = MockData.createTestEmployee();
        employee.setCompany(company);
        employeeRepository.save(employee);
        ownerRepository.save(MockData.createOwner());
    }
}

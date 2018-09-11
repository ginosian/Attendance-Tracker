package com.attendance_tracker.listener;

import com.attendance_tracker.entity.Company;
import com.attendance_tracker.entity.Employee;
import com.attendance_tracker.entity.Owner;

public class MockData {

    public static Company createTestCompany(){
        final Company company = new Company();
        company.setName("Test Company");
        company.setEmail("company@company.com");
        return company;
    }

    public static Employee createTestEmployee(){
        final Employee employee = new Employee();
        employee.setFirstName("Test employee");
        employee.setEmail("employee@employee.com");
        return employee;
    }

    public static Owner createOwner(){
        final Owner owner = new Owner();
        owner.setEmail("marta@marta.com");
        return owner;
    }

}

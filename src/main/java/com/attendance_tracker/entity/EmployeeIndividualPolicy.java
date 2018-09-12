package com.attendance_tracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_individual_policy")
public class EmployeeIndividualPolicy extends Policy{

    @OneToOne
    private Employee employee;

    @OneToOne
    private Company company;

    @Column(name = "individual_attendance_policy_active")
    private Boolean individualAttendancePolicyActive;

    @Column(name = "individual_time_off_poli_active")
    private Boolean individualTimeOffPolicyActive;

    @Column(name = "individual_vacation_policy_aActive")
    private Boolean individualVacationPolicyActive;

    // region GETTERS / SETTERS
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Boolean getIndividualAttendancePolicyActive() {
        return individualAttendancePolicyActive;
    }

    public void setIndividualAttendancePolicyActive(Boolean individualAttendancePolicyActive) {
        this.individualAttendancePolicyActive = individualAttendancePolicyActive;
    }

    public Boolean getIndividualTimeOffPolicyActive() {
        return individualTimeOffPolicyActive;
    }

    public void setIndividualTimeOffPolicyActive(Boolean individualTimeOffPolicyActive) {
        this.individualTimeOffPolicyActive = individualTimeOffPolicyActive;
    }

    public Boolean getIndividualVacationPolicyActive() {
        return individualVacationPolicyActive;
    }

    public void setIndividualVacationPolicyActive(Boolean individualVacationPolicyActive) {
        this.individualVacationPolicyActive = individualVacationPolicyActive;
    }
    // endregion
}

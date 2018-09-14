package com.attendance_tracker.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Employee")
@Table(name = "employee")
public class Employee extends User {

    // region PROPERTIES
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Embedded
    private ContactDetails contactDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_division_id", nullable = false, foreignKey = @ForeignKey(name = "business_division_employee_fk"))
    private BusinessDivision businessDivision;

    @Column(name = "joining_date")
    private LocalDateTime joiningDate;

    @Column(name = "leaving_date")
    private LocalDateTime leavingDate;
    // endregion

    //region GETTERS / SETTERS
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BusinessDivision getBusinessDivision() {
        return businessDivision;
    }

    public void setBusinessDivision(BusinessDivision businessDivision) {
        this.businessDivision = businessDivision;
    }

    public LocalDateTime getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDateTime joiningDate) {
        this.joiningDate = joiningDate;
    }

    public LocalDateTime getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(LocalDateTime leavingDate) {
        this.leavingDate = leavingDate;
    }
    //endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}

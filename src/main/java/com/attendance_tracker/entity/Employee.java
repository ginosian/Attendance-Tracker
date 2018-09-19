package com.attendance_tracker.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Employee")
@Table(name = "employee")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Employee extends User {
    // region PROPERTIES
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_division_id", nullable = false, foreignKey = @ForeignKey(name = "business_division_employee_fk"))
    private BusinessDivision businessDivision;

    @Column(name = "joining_date")
    private LocalDateTime joiningDate;

    @Column(name = "leaving_date")
    private LocalDateTime leavingDate;
    // endregion
}

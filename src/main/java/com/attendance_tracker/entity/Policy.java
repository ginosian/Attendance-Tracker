package com.attendance_tracker.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "Policy")
@Table(name = "policy")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Policy extends AbstractEntity {
    // region PROPERTIES
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "attendance_policy_policy_fk"))
    private AttendancePolicy attendancePolicy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "time_off_policy_policy_fk"))
    private TimeOffPolicy timeOffPolicy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "vacation_policy_policy_fk"))
    private VacationPolicy vacationPolicy;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "business_division_policy_fk"))
    private BusinessDivision businessDivision;
    // endregion
}
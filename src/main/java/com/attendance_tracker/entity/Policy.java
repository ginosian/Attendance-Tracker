package com.attendance_tracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "policy")
public class Policy extends AbstractEntity {

    // region PROPERTIES
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @MapsId
    @JoinColumn(foreignKey = @ForeignKey(name = "attendance_policy_policy_fk"))
    private AttendancePolicy attendancePolicy;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @MapsId
    @JoinColumn(foreignKey = @ForeignKey(name = "time_off_policy_policy_fk"))
    private TimeOffPolicy timeOffPolicy;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @MapsId
    @JoinColumn(foreignKey = @ForeignKey(name = "vacation_policy_policy_fk"))
    private VacationPolicy vacationPolicy;

    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(foreignKey = @ForeignKey(name = "business_division_policy_fk"))
    private BusinessDivision businessDivision;
    // endregion

    // region GETTERS / SETTERS
    public AttendancePolicy getAttendancePolicy() {
        return attendancePolicy;
    }

    public void setAttendancePolicy(AttendancePolicy attendancePolicy) {
        this.attendancePolicy = attendancePolicy;
    }

    public TimeOffPolicy getTimeOffPolicy() {
        return timeOffPolicy;
    }

    public void setTimeOffPolicy(TimeOffPolicy timeOffPolicy) {
        this.timeOffPolicy = timeOffPolicy;
    }

    public VacationPolicy getVacationPolicy() {
        return vacationPolicy;
    }

    public void setVacationPolicy(VacationPolicy vacationPolicy) {
        this.vacationPolicy = vacationPolicy;
    }

    public BusinessDivision getBusinessDivision() {
        return businessDivision;
    }

    public void setBusinessDivision(BusinessDivision businessDivision) {
        this.businessDivision = businessDivision;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}
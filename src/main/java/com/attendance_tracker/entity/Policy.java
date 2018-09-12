package com.attendance_tracker.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "policy")
public class Policy extends AbstractEntity{

    @Embedded
    private AttendancePolicy attendancePolicy;

    @Embedded
    private TimeOffPolicy timeOffPolicy;

    @Embedded
    private VacationPolicy vacationPolicy;

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
    // endregion
}
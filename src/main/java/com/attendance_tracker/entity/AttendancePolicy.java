package com.attendance_tracker.entity;

import com.attendance_tracker.misc.AttendanceCalculationType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attendance_policy")
public class AttendancePolicy extends AbstractEntity{

    @OneToOne
    private Policy policy;

    @Column(name = "attendance_calculation_type")
    @Enumerated(EnumType.STRING)
    private AttendanceCalculationType attendanceCalculationType;

    @OneToMany
    private Set<Period> inPeriods;

    @OneToMany
    private Set<Period> outPeriods;

    @Column(name = "working_hours_day")
    private Integer workingHoursPerDay;

    @Column(name = "working_hours_week")
    private Integer workingHoursPerWeek;

    @Column(name = "working_days_week")
    private Integer workingDaysPerWeek;

    // region GETTERS / SETTERS

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public AttendanceCalculationType getAttendanceCalculationType() {
        return attendanceCalculationType;
    }

    public void setAttendanceCalculationType(AttendanceCalculationType attendanceCalculationType) {
        this.attendanceCalculationType = attendanceCalculationType;
    }

    public Set<Period> getInPeriods() {
        return inPeriods;
    }

    public void setInPeriods(Set<Period> inPeriods) {
        this.inPeriods = inPeriods;
    }

    public Set<Period> getOutPeriods() {
        return outPeriods;
    }

    public void setOutPeriods(Set<Period> outPeriods) {
        this.outPeriods = outPeriods;
    }

    public Integer getWorkingHoursPerDay() {
        return workingHoursPerDay;
    }

    public void setWorkingHoursPerDay(Integer workingHoursPerDay) {
        this.workingHoursPerDay = workingHoursPerDay;
    }

    public Integer getWorkingHoursPerWeek() {
        return workingHoursPerWeek;
    }

    public void setWorkingHoursPerWeek(Integer workingHoursPerWeek) {
        this.workingHoursPerWeek = workingHoursPerWeek;
    }

    public Integer getWorkingDaysPerWeek() {
        return workingDaysPerWeek;
    }

    public void setWorkingDaysPerWeek(Integer workingDaysPerWeek) {
        this.workingDaysPerWeek = workingDaysPerWeek;
    }

    // endregion

}

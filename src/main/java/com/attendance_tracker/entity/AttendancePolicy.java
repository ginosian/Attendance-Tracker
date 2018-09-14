package com.attendance_tracker.entity;

import com.attendance_tracker.misc.AttendanceCalculationType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attendance_policy")
public class AttendancePolicy extends AbstractEntity{

    @Column(name = "attendance_calculation_type")
    @Enumerated(EnumType.STRING)
    private AttendanceCalculationType attendanceCalculationType;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<PeriodDetail> periods;

    @Column(name = "working_hours_day")
    private Integer workingHoursPerDay;

    @Column(name = "working_hours_week")
    private Integer workingHoursPerWeek;

    @Column(name = "working_days_week")
    private Integer workingDaysPerWeek;

    // region GETTERS / SETTERS

    public AttendanceCalculationType getAttendanceCalculationType() {
        return attendanceCalculationType;
    }

    public void setAttendanceCalculationType(AttendanceCalculationType attendanceCalculationType) {
        this.attendanceCalculationType = attendanceCalculationType;
    }

    public Set<PeriodDetail> getPeriods() {
        return periods;
    }

    public void setPeriods(Set<PeriodDetail> periods) {
        this.periods = periods;
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

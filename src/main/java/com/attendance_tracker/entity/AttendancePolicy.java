package com.attendance_tracker.entity;

import com.attendance_tracker.misc.AttendanceCalculationType;

import javax.persistence.*;

@Embeddable
public class AttendancePolicy {

    @Column(name = "attendance_calculation_type")
    @Enumerated(EnumType.STRING)
    private AttendanceCalculationType attendanceCalculationType;

    @Embedded
    private WorkingDaySchedule workingDaySchedule;

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

    public WorkingDaySchedule getWorkingDaySchedule() {
        return workingDaySchedule;
    }

    public void setWorkingDaySchedule(WorkingDaySchedule workingDaySchedule) {
        this.workingDaySchedule = workingDaySchedule;
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

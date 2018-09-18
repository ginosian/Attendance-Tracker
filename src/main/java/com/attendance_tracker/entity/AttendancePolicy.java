package com.attendance_tracker.entity;

import com.attendance_tracker.misc.AttendanceCalculationType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "AttendancePolicy")
@Table(name = "attendance_policy")
public class AttendancePolicy extends AbstractEntity {

    // region PROPERTIES
    @Column(name = "attendance_calculation_type")
    @Enumerated(EnumType.STRING)
    private AttendanceCalculationType attendanceCalculationType;

    @OneToMany(mappedBy = "attendancePolicy", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PeriodDetail> periods = new HashSet<>();

    @Column(name = "working_hours_day")
    private Integer workingHoursPerDay;

    @Column(name = "working_hours_week")
    private Integer workingHoursPerWeek;

    @Column(name = "working_days_week")
    private Integer workingDaysPerWeek;
    // endregion

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

    //region EQUALS / HASHCODE / TOSTRING
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        final AttendancePolicy that = (AttendancePolicy) o;
//        return new EqualsBuilder()
//                .appendSuper(super.equals(o))
//                .append(attendanceCalculationType, that.attendanceCalculationType)
//                .append(periods, that.periods )
//                .append(workingHoursPerDay, that.workingHoursPerDay)
//                .append(workingHoursPerWeek, that.workingHoursPerWeek)
//                .append(workingDaysPerWeek, that.workingDaysPerWeek)
//                .isEquals();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder(17, 37)
//                .appendSuper(super.hashCode())
//                .append(attendanceCalculationType)
//                .append(periods)
//                .append(workingHoursPerDay)
//                .append(workingHoursPerWeek)
//                .append(workingDaysPerWeek)
//                .toHashCode();
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this)
//                .appendSuper(super.toString())
//                .append("attendanceCalculationType", attendanceCalculationType)
//                .append("periods ", periods)
//                .append("workingHoursPerDay", workingHoursPerDay)
//                .append("workingHoursPerWeek", workingHoursPerWeek)
//                .append("workingDaysPerWeek", workingDaysPerWeek)
//                .toString();
//    }
    //endregion
}

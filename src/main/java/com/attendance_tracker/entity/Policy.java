package com.attendance_tracker.entity;

import javax.persistence.*;

@Entity(name = "Policy")
@Table(name = "policy")
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
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        final Policy that = (Policy) o;
//        return new EqualsBuilder()
//                .appendSuper(super.equals(o))
//                .append(attendancePolicy, that.attendancePolicy)
//                .append(timeOffPolicy, that.timeOffPolicy)
//                .append(vacationPolicy, that.vacationPolicy)
//                .append(businessDivision, that.businessDivision)
//                .isEquals();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder(17, 37)
//                .appendSuper(super.hashCode())
//                .append(attendancePolicy)
//                .append(timeOffPolicy)
//                .append(vacationPolicy)
//                .append(businessDivision)
//                .toHashCode();
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this)
//                .appendSuper(super.toString())
//                .append("attendancePolicy", attendancePolicy)
//                .append("timeOffPolicy", timeOffPolicy)
//                .append("vacationPolicy", vacationPolicy)
//                .append("businessDivision", businessDivision)
//                .toString();
//    }
    //endregion
}
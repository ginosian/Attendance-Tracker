package com.attendance_tracker.entity;


import com.attendance_tracker.misc.PeriodType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "period_details")
public class PeriodDetail extends AbstractEntity {

    // region PROPERTIES
    @Column(name = "period_type")
    @Enumerated(EnumType.STRING)
    private PeriodType periodType;

    @OneToMany(mappedBy = "periodDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Period> periods = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendance_policy_id", nullable = false, foreignKey = @ForeignKey(name = "attendance_policy_period_details_fk"))
    private AttendancePolicy attendancePolicy;
    // endregion

    // region GETTERS / SETTERS
    public PeriodType getPeriodType() {
        return periodType;
    }

    public void setPeriodType(PeriodType periodType) {
        this.periodType = periodType;
    }

    public Set<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(Set<Period> periods) {
        this.periods = periods;
    }

    public AttendancePolicy getAttendancePolicy() {
        return attendancePolicy;
    }

    public void setAttendancePolicy(AttendancePolicy attendancePolicy) {
        this.attendancePolicy = attendancePolicy;
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
//        final PeriodDetail that = (PeriodDetail) o;
//        return new EqualsBuilder()
//                .appendSuper(super.equals(o))
//                .append(periodType, that.periodType)
//                .append(periods, that.periods)
//                .isEquals();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder(17, 37)
//                .appendSuper(super.hashCode())
//                .append(periodType)
//                .append(periods)
//                .toHashCode();
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this)
//                .appendSuper(super.toString())
//                .append("periodType", periodType)
//                .append("periods", periods)
//                .toString();
//    }
    //endregion
}

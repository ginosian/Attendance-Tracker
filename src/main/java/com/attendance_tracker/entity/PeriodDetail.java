package com.attendance_tracker.entity;


import com.attendance_tracker.misc.PeriodType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "period_details")
public class PeriodDetail extends AbstractEntity {

    // region PROPERTIES
    @Column(name = "period_type")
    @Enumerated(EnumType.STRING)
    private PeriodType periodType;

    @OneToMany(mappedBy = "periodDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Period> periods;

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
    //endregion
}

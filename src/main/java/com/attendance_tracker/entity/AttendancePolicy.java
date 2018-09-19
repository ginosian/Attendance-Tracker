package com.attendance_tracker.entity;

import com.attendance_tracker.misc.AttendanceCalculationType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "AttendancePolicy")
@Table(name = "attendance_policy")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"periods"})
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
}

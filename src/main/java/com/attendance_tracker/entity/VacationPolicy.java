package com.attendance_tracker.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "VacationPolicy")
@Table(name = "vacation_policy")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class VacationPolicy extends AbstractEntity {
    // region PROPERTIES
    @Column(name = "vacation_per_day")
    private Double vacationPerDay;

    @Column(name = "vacation_per_week")
    private Double vacationPerWeek;

    @Column(name = "vacation_per_month")
    private Double vacationPerMonth;

    @Column(name = "vacation_per_year")
    private Double vacationPerYear;
    // endregion
}

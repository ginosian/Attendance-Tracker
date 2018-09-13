package com.attendance_tracker.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VacationPolicy {

    @Column(name = "vacation_per_day")
    private Double vacationPerDay;

    @Column(name = "vacation_per_week")
    private Double vacationPerWeek;

    @Column(name = "vacation_per_month")
    private Double vacationPerMonth;

    @Column(name = "vacation_per_year")
    private Double vacationPerYear;

    // region GETTERS / SETTERS

    public Double getVacationPerDay() {
        return vacationPerDay;
    }

    public void setVacationPerDay(Double vacationPerDay) {
        this.vacationPerDay = vacationPerDay;
    }

    public Double getVacationPerWeek() {
        return vacationPerWeek;
    }

    public void setVacationPerWeek(Double vacationPerWeek) {
        this.vacationPerWeek = vacationPerWeek;
    }

    public Double getVacationPerMonth() {
        return vacationPerMonth;
    }

    public void setVacationPerMonth(Double vacationPerMonth) {
        this.vacationPerMonth = vacationPerMonth;
    }

    public Double getVacationPerYear() {
        return vacationPerYear;
    }

    public void setVacationPerYear(Double vacationPerYear) {
        this.vacationPerYear = vacationPerYear;
    }

    // endregion
}

package com.attendance_tracker.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VacationPolicy {

    @Column(name = "vacation_per_day")
    private Integer vacationPerDay;

    @Column(name = "vacation_per_week")
    private Integer vacationPerWeek;

    @Column(name = "vacation_per_month")
    private Integer vacationPerMonth;

    @Column(name = "vacation_per_year")
    private Integer vacationPerYear;

    // region GETTERS / SETTERS
    public Integer getVacationPerDay() {
        return vacationPerDay;
    }

    public void setVacationPerDay(Integer vacationPerDay) {
        this.vacationPerDay = vacationPerDay;
    }

    public Integer getVacationPerWeek() {
        return vacationPerWeek;
    }

    public void setVacationPerWeek(Integer vacationPerWeek) {
        this.vacationPerWeek = vacationPerWeek;
    }

    public Integer getVacationPerMonth() {
        return vacationPerMonth;
    }

    public void setVacationPerMonth(Integer vacationPerMonth) {
        this.vacationPerMonth = vacationPerMonth;
    }

    public Integer getVacationPerYear() {
        return vacationPerYear;
    }

    public void setVacationPerYear(Integer vacationPerYear) {
        this.vacationPerYear = vacationPerYear;
    }
    // endregion
}

package com.attendance_tracker.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "VacationPolicy")
@Table(name = "vacation_policy")
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

    //region EQUALS / HASHCODE / TOSTRING
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final VacationPolicy that = (VacationPolicy) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(vacationPerDay, that.vacationPerDay)
                .append(vacationPerWeek, that.vacationPerWeek)
                .append(vacationPerMonth, that.vacationPerMonth)
                .append(vacationPerYear, that.vacationPerYear)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(vacationPerDay)
                .append(vacationPerWeek)
                .append(vacationPerMonth)
                .append(vacationPerYear)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("vacationPerDay", vacationPerDay)
                .append("vacationPerWeek", vacationPerWeek)
                .append("vacationPerMonth", vacationPerMonth)
                .append("vacationPerYear", vacationPerYear)
                .toString();
    }
    //endregion
}

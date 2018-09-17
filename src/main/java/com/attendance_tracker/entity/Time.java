package com.attendance_tracker.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Time {

    // region PROPERTIES
    @Column(name = "hour")
    private Integer hour;

    @Column(name = "minute")
    private Integer minute;
    // endregion

    // region GETTERS / SETTERS
    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
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
        final Time that = (Time) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(hour, that.hour)
                .append(minute, that.minute)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(hour)
                .append(minute)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("hour", hour)
                .append("minute", minute)
                .toString();
    }
    //endregion
}

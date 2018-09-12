package com.attendance_tracker.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Time {

    private Integer hour;
    private Integer minute;

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
}

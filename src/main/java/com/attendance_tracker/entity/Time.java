package com.attendance_tracker.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Time implements Serializable {

    @Column(name = "hour")
    private Integer hour;
    @Column(name = "minute")
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

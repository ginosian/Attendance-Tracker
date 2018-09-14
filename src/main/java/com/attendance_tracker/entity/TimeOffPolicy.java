package com.attendance_tracker.entity;

import com.attendance_tracker.misc.TimeOffMinDuration;

import javax.persistence.*;


@Entity(name = "TimeOffPolicy")
@Table(name = "time_off_policy")
public class TimeOffPolicy extends AbstractEntity {

    // region PROPERTIES
    @Column(name = "time_off_min_duration")
    @Enumerated(EnumType.STRING)
    private TimeOffMinDuration timeOffMinDuration;
    // endregion

    // region GETTERS / SETTERS
    public TimeOffMinDuration getTimeOffMinDuration() {
        return timeOffMinDuration;
    }

    public void setTimeOffMinDuration(TimeOffMinDuration timeOffMinDuration) {
        this.timeOffMinDuration = timeOffMinDuration;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}

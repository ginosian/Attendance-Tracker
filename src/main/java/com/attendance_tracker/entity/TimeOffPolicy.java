package com.attendance_tracker.entity;

import com.attendance_tracker.misc.TimeOffMinDuration;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Embeddable
public class TimeOffPolicy {

    @Column(name = "time_off_min_duration")
    @Enumerated(EnumType.STRING)
    private TimeOffMinDuration timeOffMinDuration;

    @Column(name = "register_as_vacation_immediate")
    private Boolean registerAsVacationImmediate;

    // region GETTERS / SETTERS
    public TimeOffMinDuration getTimeOffMinDuration() {
        return timeOffMinDuration;
    }

    public void setTimeOffMinDuration(TimeOffMinDuration timeOffMinDuration) {
        this.timeOffMinDuration = timeOffMinDuration;
    }

    public Boolean getRegisterAsVacationImmediate() {
        return registerAsVacationImmediate;
    }

    public void setRegisterAsVacationImmediate(Boolean registerAsVacationImmediate) {
        this.registerAsVacationImmediate = registerAsVacationImmediate;
    }
    // endregion
}

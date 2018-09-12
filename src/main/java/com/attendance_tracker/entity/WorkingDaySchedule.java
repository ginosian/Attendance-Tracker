package com.attendance_tracker.entity;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.Set;

@Embeddable
public class WorkingDaySchedule {

    @Embedded
    private Set<Period> in;

    @Embedded
    private Set<Period> out;

    // region GETTERS / SETTERS
    public Set<Period> getIn() {
        return in;
    }

    public void setIn(Set<Period> in) {
        this.in = in;
    }

    public Set<Period> getOut() {
        return out;
    }

    public void setOut(Set<Period> out) {
        this.out = out;
    }
    // endregion
}

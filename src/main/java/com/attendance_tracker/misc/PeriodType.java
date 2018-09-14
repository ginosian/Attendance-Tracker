package com.attendance_tracker.misc;

public enum PeriodType {
    WORK(true),
    LUNCH(false);

    private Boolean in;

    PeriodType(Boolean in) {
        this.in = in;
    }

    public Boolean getIn() {
        return in;
    }
}

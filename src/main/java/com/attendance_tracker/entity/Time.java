package com.attendance_tracker.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class Time {
    // region PROPERTIES
    @Column(name = "hour")
    private Integer hour;

    @Column(name = "minute")
    private Integer minute;
    // endregion
}

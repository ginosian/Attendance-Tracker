package com.attendance_tracker.entity;

import com.attendance_tracker.misc.TimeOffMinDuration;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity(name = "TimeOffPolicy")
@Table(name = "time_off_policy")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class TimeOffPolicy extends AbstractEntity {
    // region PROPERTIES
    @Column(name = "time_off_min_duration")
    @Enumerated(EnumType.STRING)
    private TimeOffMinDuration timeOffMinDuration;
    // endregion
}

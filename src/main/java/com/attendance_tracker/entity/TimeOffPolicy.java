package com.attendance_tracker.entity;

import com.attendance_tracker.misc.TimeOffMinDuration;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TimeOffPolicy that = (TimeOffPolicy) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(timeOffMinDuration, that.timeOffMinDuration)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(timeOffMinDuration)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("timeOffMinDuration",timeOffMinDuration)
                .toString();
    }
    //endregion
}

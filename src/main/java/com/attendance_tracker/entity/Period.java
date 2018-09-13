package com.attendance_tracker.entity;

import com.attendance_tracker.misc.TimeBufferType;

import javax.persistence.*;

@Entity
@Table(name = "period")
public class Period extends AbstractEntity{

    @AttributeOverrides({
            @AttributeOverride(name = "hour", column = @Column(name = "start_hour")),
            @AttributeOverride(name = "minute", column = @Column(name = "start_minute"))
    })
    @Embedded
    private Time start;

    @AttributeOverrides({
            @AttributeOverride(name = "hour", column = @Column(name = "end_hour")),
            @AttributeOverride(name = "minute", column = @Column(name = "end_minute"))
    })
    @Embedded
    private Time end;

    @AttributeOverrides({
            @AttributeOverride(name = "hour", column = @Column(name = "start_buffer_hour")),
            @AttributeOverride(name = "minute", column = @Column(name = "start_buffer_minute"))
    })
    @Embedded
    private Time startBuffer;

    @Column(name = "start_buffer_type")
    @Enumerated(EnumType.STRING)
    private TimeBufferType startBufferType;

    @AttributeOverrides({
            @AttributeOverride(name = "hour", column = @Column(name = "end_buffer_hour")),
            @AttributeOverride(name = "minute", column = @Column(name = "end_buffer_minute"))
    })
    @Embedded
    private Time endBuffer;

    @Column(name = "end_buffer_type")
    @Enumerated(EnumType.STRING)
    private TimeBufferType endBufferType;

    // region GETTERS / SETTERS

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public Time getStartBuffer() {
        return startBuffer;
    }

    public void setStartBuffer(Time startBuffer) {
        this.startBuffer = startBuffer;
    }

    public TimeBufferType getStartBufferType() {
        return startBufferType;
    }

    public void setStartBufferType(TimeBufferType startBufferType) {
        this.startBufferType = startBufferType;
    }

    public Time getEndBuffer() {
        return endBuffer;
    }

    public void setEndBuffer(Time endBuffer) {
        this.endBuffer = endBuffer;
    }

    public TimeBufferType getEndBufferType() {
        return endBufferType;
    }

    public void setEndBufferType(TimeBufferType endBufferType) {
        this.endBufferType = endBufferType;
    }

    // endregion
}

package com.attendance_tracker.entity;

import com.attendance_tracker.misc.TimeBufferType;

import javax.persistence.*;

@Entity
@Table(name = "period")
public class Period extends AbstractEntity {

    // region PROPERTIES
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "period_detail_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "period_detail_period_fk")
    )
    private PeriodDetail periodDetail;
    // endregion

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

    public PeriodDetail getPeriodDetail() {
        return periodDetail;
    }

    public void setPeriodDetail(PeriodDetail periodDetail) {
        this.periodDetail = periodDetail;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        final Period that = (Period) o;
//        return new EqualsBuilder()
//                .appendSuper(super.equals(o))
//                .append(start, that.start)
//                .append(end, that.end)
//                .append(startBuffer, that.startBuffer)
//                .append(startBufferType, that.startBufferType)
//                .append(endBuffer, that.endBuffer)
//                .append(endBufferType, that.endBufferType)
//                .isEquals();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder(17, 37)
//                .appendSuper(super.hashCode())
//                .append(start)
//                .append(end)
//                .append(startBuffer)
//                .append(startBufferType)
//                .append(endBuffer)
//                .append(endBufferType)
//                .toHashCode();
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this)
//                .appendSuper(super.toString())
//                .append("start", start)
//                .append("end", end)
//                .append("startBuffer", startBuffer)
//                .append("startBufferType", startBufferType)
//                .append("endBuffer", endBuffer)
//                .append("endBufferType", endBufferType)
//                .toString();
//    }
    //endregion
}

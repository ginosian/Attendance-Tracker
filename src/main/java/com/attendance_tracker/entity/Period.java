package com.attendance_tracker.entity;

import com.attendance_tracker.misc.TimeBufferType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "period")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
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
}

package com.attendance_tracker.entity;


import com.attendance_tracker.misc.PeriodType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "period_details")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"periods"})
public class PeriodDetail extends AbstractEntity {
    // region PROPERTIES
    @Column(name = "period_type")
    @Enumerated(EnumType.STRING)
    private PeriodType periodType;

    @OneToMany(mappedBy = "periodDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Period> periods = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendance_policy_id", nullable = false, foreignKey = @ForeignKey(name = "attendance_policy_period_details_fk"))
    private AttendancePolicy attendancePolicy;
    // endregion
}

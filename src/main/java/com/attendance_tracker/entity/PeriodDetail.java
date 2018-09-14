package com.attendance_tracker.entity;


import com.attendance_tracker.misc.PeriodType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "period_details")
public class PeriodDetail extends AbstractEntity{

    @Column(name = "period_type")
    @Enumerated(EnumType.STRING)
    private PeriodType periodType;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Period> periods;

    public PeriodType getPeriodType() {
        return periodType;
    }

    public void setPeriodType(PeriodType periodType) {
        this.periodType = periodType;
    }

    public Set<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(Set<Period> periods) {
        this.periods = periods;
    }
}

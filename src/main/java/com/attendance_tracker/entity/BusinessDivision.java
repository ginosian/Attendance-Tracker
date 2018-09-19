package com.attendance_tracker.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "BusinessDivision")
@Table(name = "business_division")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "employees")
public class BusinessDivision extends AbstractEntity {
    // region PROPERTIES
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_details_id", nullable = false, foreignKey = @ForeignKey(name = "business_details_business_division_fk"))
    private BusinessDetails businessDetails;

    @Embedded
    private ContactDetails contactDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "default_policy_business_division_fk"))
    private Policy defaultPolicy;

    @OneToMany(mappedBy = "businessDivision")
    private Set<Employee> employees = new HashSet<>();
    // endregion
}
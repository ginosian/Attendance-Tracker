package com.attendance_tracker.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "BusinessDetails")
@Table(name = "business_details")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "businessDivisions")
public class BusinessDetails extends AbstractEntity {
    // region PROPERTIES
    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "business_business_details_fk"))
    private Business business;

    @OneToMany(mappedBy = "businessDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BusinessDivision> businessDivisions = new HashSet<>();
    // endregion
}

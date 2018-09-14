package com.attendance_tracker.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "BusinessDetails")
@Table(name = "business_details")
public class BusinessDetails extends AbstractEntity {

    // region PROPERTIES
    @OneToOne(optional = false)
    @MapsId
    @JoinColumn(foreignKey = @ForeignKey(name = "business_business_details_fk"))
    private Business business;

    @OneToMany(mappedBy = "businessDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BusinessDivision> businessDivisions = new HashSet<>();
    // endregion

    // region GETTERS / SETTERS
    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Set<BusinessDivision> getBusinessDivisions() {
        return businessDivisions;
    }

    public void setBusinessDivisions(Set<BusinessDivision> businessDivisions) {
        this.businessDivisions = businessDivisions;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}

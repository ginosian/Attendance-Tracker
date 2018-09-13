package com.attendance_tracker.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "business_details")
public class BusinessDetails extends AbstractEntity{

    @OneToOne(optional = false)
    private Business business;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<BusinessDivision> businessDivisions;

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


}

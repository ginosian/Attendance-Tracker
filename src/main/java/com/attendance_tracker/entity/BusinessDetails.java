package com.attendance_tracker.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "BusinessDetails")
@Table(name = "business_details")
public class BusinessDetails extends AbstractEntity {

    // region PROPERTIES
    @OneToOne(optional = false)
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
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        final BusinessDetails that = (BusinessDetails) o;
//        return new EqualsBuilder()
//                .appendSuper(super.equals(o))
//                .append(business, that.business)
//                .append(businessDivisions, that.businessDivisions)
//                .isEquals();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder(17, 37)
//                .appendSuper(super.hashCode())
//                .append(business)
//                .append(businessDivisions)
//                .toHashCode();
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this)
//                .appendSuper(super.toString())
//                .append("business", business)
//                .append("businessDivisions", businessDivisions)
//                .toString();
//    }
    //endregion
}

package com.attendance_tracker.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "BusinessDivision")
@Table(name = "business_division")
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

    // region GETTERS / SETTERS
    public BusinessDetails getBusinessDetails() {
        return businessDetails;
    }

    public void setBusinessDetails(BusinessDetails businessDetails) {
        this.businessDetails = businessDetails;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Policy getDefaultPolicy() {
        return defaultPolicy;
    }

    public void setDefaultPolicy(Policy defaultPolicy) {
        this.defaultPolicy = defaultPolicy;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}
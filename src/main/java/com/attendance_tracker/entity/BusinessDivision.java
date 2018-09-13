package com.attendance_tracker.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "business_division")
public class BusinessDivision extends AbstractEntity {

    @Embedded
    private ContactDetails contactDetails;

    @OneToOne
    private Policy defaultPolicy;

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

}
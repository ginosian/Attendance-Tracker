package com.attendance_tracker.entity;


import javax.persistence.*;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends AbstractEntity {

    @Embedded
    private ContactDetails contactDetails;

    @Column(name = "approved")
    private Boolean approved;

    // region GETTERS / SETTERS

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    // endregion
}

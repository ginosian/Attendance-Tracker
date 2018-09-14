package com.attendance_tracker.entity;


import javax.persistence.*;

@Entity(name = "User")
@Table(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends AbstractEntity {

    // region PROPERTIES
    @Embedded
    private ContactDetails contactDetails;

    @Column(name = "approved")
    private Boolean approved;
    // endregion

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

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}

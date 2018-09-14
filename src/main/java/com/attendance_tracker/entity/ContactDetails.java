package com.attendance_tracker.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class ContactDetails {

    // region PROPERTIES
    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Embedded
    private Address address;
    // endregion

    // region GETTERS / SETTERS
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}

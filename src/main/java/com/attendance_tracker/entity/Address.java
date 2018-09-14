package com.attendance_tracker.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    // region PROPERTIES
    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "postcode", nullable = false)
    private String postcode;
    // endregion

    //region GETTERS / SETTERS
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}

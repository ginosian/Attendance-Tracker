package com.attendance_tracker.entity;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Address that = (Address) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(country, that.country)
                .append(postcode, that.postcode)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(country)
                .append(postcode)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("country", country)
                .append("postcode", postcode)
                .toString();
    }
    //endregion
}

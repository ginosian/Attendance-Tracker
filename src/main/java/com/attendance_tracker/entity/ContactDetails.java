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
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        final ContactDetails that = (ContactDetails) o;
//        return new EqualsBuilder()
//                .appendSuper(super.equals(o))
//                .append(phone, that.phone)
//                .append(email, that.email)
//                .append(address, that.address)
//                .isEquals();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder(17, 37)
//                .appendSuper(super.hashCode())
//                .append(phone)
//                .append(email)
//                .append(address)
//                .toHashCode();
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this)
//                .appendSuper(super.toString())
//                .append("phone", phone)
//                .append("email", email)
//                .append("address", address)
//                .toString();
//    }
    //endregion
}

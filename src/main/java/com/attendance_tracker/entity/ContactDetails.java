package com.attendance_tracker.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class ContactDetails {
    // region PROPERTIES
    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Embedded
    private Address address;
    // endregion
}

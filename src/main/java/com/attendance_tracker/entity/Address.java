package com.attendance_tracker.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@EqualsAndHashCode
public class Address {
    // region PROPERTIES
    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "postcode", nullable = false)
    private String postcode;
    // endregion
}

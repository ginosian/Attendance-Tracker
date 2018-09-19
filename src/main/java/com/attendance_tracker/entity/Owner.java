package com.attendance_tracker.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Owner")
@Table(name = "owner")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Owner extends User {
    // region PROPERTIES
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    // endregion
}

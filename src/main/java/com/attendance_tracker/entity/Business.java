package com.attendance_tracker.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Business")
@Table(name = "business")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Business extends User {
    // region PROPERTIES
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    // endregion
}

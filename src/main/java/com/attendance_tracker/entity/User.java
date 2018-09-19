package com.attendance_tracker.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "User")
@Table(name = "user_detail")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class User extends AbstractEntity {
    // region PROPERTIES
    @Embedded
    private ContactDetails contactDetails;
    // endregion
}

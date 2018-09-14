package com.attendance_tracker.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Business")
@Table(name = "business")
public class Business extends User {

    // region PROPERTIES
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    // endregion

    //region GETTERS / SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}

package com.attendance_tracker.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "business")
public class Business extends User {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    //region GETTERS / SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // endregion

    //region equals/hashcode/toString
    //endregion
}

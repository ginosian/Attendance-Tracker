package com.attendance_tracker.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends User{

    @Column(name = "name")
    private String name;

    //region GETTERS/SETTERS

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

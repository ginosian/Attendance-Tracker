package com.attendance_tracker.entity;

import com.attendance_tracker.misc.PermissionType;

import javax.persistence.*;

@Entity
@Table(name = "permission")
public class Permission extends AbstractEntity {

    @Column(name = "type", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PermissionType type;

    //region GETTERS/SETTERS

    public PermissionType getType() {
        return type;
    }

    public void setType(PermissionType type) {
        this.type = type;
    }

    // endregion

    //region equals/hashcode/toString
    //endregion
}

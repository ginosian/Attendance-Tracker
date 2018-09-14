package com.attendance_tracker.entity;

import com.attendance_tracker.misc.PermissionType;

import javax.persistence.*;

@Entity
@Table(name = "permission")
public class Permission extends AbstractEntity {

    // region PROPERTIES
    @Column(name = "type", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PermissionType type;
    // endregion

    //region GETTERS / SETTERS
    public PermissionType getType() {
        return type;
    }
    public void setType(PermissionType type) {
        this.type = type;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}

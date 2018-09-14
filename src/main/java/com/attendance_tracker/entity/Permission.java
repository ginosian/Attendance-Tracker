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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "role_permission_fk"))
    private Role role;
    // endregion

    //region GETTERS / SETTERS
    public PermissionType getType() {
        return type;
    }

    public void setType(PermissionType type) {
        this.type = type;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}

package com.attendance_tracker.entity;

import com.attendance_tracker.misc.RoleType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends AbstractEntity {

    // region PROPERTIES
    @Column(name = "type", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleType type;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Permission> permissions;
    // endregion

    //region GETTERS / SETTERS
    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
    //endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion

}

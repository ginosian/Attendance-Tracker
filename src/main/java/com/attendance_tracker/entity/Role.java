package com.attendance_tracker.entity;

import com.attendance_tracker.misc.RoleType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends AbstractEntity{

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_permission",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private Set<Permission> permissions;

    @Column(name = "type", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleType type;

    //region GETTERS / SETTERS
    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }
    //endregion

    //region equals/hashcode/toString
    //endregion

}

package com.attendance_tracker.entity;

import com.attendance_tracker.misc.RoleType;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends AbstractEntity  implements GrantedAuthority {

    // region PROPERTIES
    @Column(name = "type", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleType type;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Permission> permissions = new HashSet<>();
    // endregion

    //region GETTERS / SETTERS
    public RoleType getType() {
        return type;
    }
    public void setType(RoleType type) {
        this.type = type;
    }
    @Override
    public String getAuthority() {
        return this.type.name();
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
    //endregion

    //region EQUALS / HASHCODE / TOSTRING
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        final Role that = (Role) o;
//        return new EqualsBuilder()
//                .appendSuper(super.equals(o))
//                .append(type, that.type)
//                .append(permissions, that.permissions)
//                .isEquals();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder(17, 37)
//                .appendSuper(super.hashCode())
//                .append(type)
//                .append(permissions)
//                .toHashCode();
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this)
//                .appendSuper(super.toString())
//                .append("type", type)
//                .append("permissions", permissions)
//                .toString();
//    }
    //endregion

}

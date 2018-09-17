package com.attendance_tracker.entity;

import com.attendance_tracker.misc.PermissionType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Permission that = (Permission) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(type, that.type)
                .append(role, that.role)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(type)
                .append(role)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("type", type)
                .append("role", role)
                .toString();
    }
    //endregion
}

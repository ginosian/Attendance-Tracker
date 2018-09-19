package com.attendance_tracker.entity;

import com.attendance_tracker.misc.PermissionType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "permission")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Permission extends AbstractEntity {
    // region PROPERTIES
    @Column(name = "type", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PermissionType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false, foreignKey = @ForeignKey(name = "role_permission_fk"))
    private Role role;
    // endregion
}

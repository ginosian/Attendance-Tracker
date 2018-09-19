package com.attendance_tracker.entity;

import com.attendance_tracker.misc.RoleType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, exclude = {"permissions"})
public class Role extends AbstractEntity  implements GrantedAuthority {
    // region PROPERTIES
    @Column(name = "type", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private RoleType type;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Permission> permissions = new HashSet<>();
    // endregion

    //region IMPLEMENTATIONS
    @Override
    public String getAuthority() {
        return this.type.name();
    }
    //endregion
}

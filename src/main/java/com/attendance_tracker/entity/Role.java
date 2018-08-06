package com.attendance_tracker.entity;

import com.attendance_tracker.misc.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role extends AbstractEntity{

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_permission",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private List<Permission> permissions;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType type;

    @JsonIgnoreProperties
    @Column(name = "non_expired")
    private Boolean accountNonExpired;

    @JsonIgnoreProperties
    @Column(name = "non_locked")
    private Boolean accountNonLocked;

    @JsonIgnoreProperties
    @Column(name = "credentials_non_expired")
    private Boolean credentialsNonExpired;

    @JsonIgnoreProperties
    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "approved")
    private Boolean approved;

    //region GETTERS/SETTERS

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    //endregion

    //region equals/hashcode/toString
    //endregion

}

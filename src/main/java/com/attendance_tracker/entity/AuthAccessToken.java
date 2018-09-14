package com.attendance_tracker.entity;

import javax.persistence.*;

@Entity(name = "AuthAccessToken")
@Table(name = "auth_access_token")
public class AuthAccessToken extends AbstractEntity {

    // region PROPERTIES
    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "user_auth_access_token_fk"))
    private Authority user;

    @Column(name = "description")
    private String description;
    // endregion

    //region GETTERS / SETTERS
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Authority getUser() {
        return user;
    }

    public void setUser(Authority user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}

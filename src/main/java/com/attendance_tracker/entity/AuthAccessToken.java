package com.attendance_tracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "auth_access_token")
public class AuthAccessToken extends AbstractEntity{

    @Column(name = "token")
    private String token;

    @OneToOne
    @MapsId(value = "user_id")
    private User user;

    @Column(name = "description")
    private String description;

    //region GETTERS / SETTERS

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // endregion

    //region equals/hashcode/toString
    //endregion
}

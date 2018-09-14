package com.attendance_tracker.entity;

import javax.persistence.*;

@Entity(name = "Authority")
@Table(name = "authority")
public class Authority extends AbstractEntity {

    // region PROPERTIES
    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "user_authority_fk"))
    private User user;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "user_user_details_fk"))
    private UserDetails userDetails;
    // endregion

    //region GETTERS / SETTERS
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}

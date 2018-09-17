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
    private APIUserDetails APIUserDetails;
    // endregion

    //region GETTERS / SETTERS
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public APIUserDetails getAPIUserDetails() {
        return APIUserDetails;
    }

    public void setAPIUserDetails(APIUserDetails APIUserDetails) {
        this.APIUserDetails = APIUserDetails;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
    //endregion
}

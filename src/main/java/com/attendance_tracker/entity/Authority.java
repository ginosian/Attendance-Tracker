package com.attendance_tracker.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
    private APIUserDetail APIUserDetail;
    // endregion

    //region GETTERS / SETTERS
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public APIUserDetail getAPIUserDetail() {
        return APIUserDetail;
    }

    public void setAPIUserDetail(APIUserDetail APIUserDetail) {
        this.APIUserDetail = APIUserDetail;
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
        final Authority that = (Authority) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(user, that.user)
                .append(APIUserDetail, that.APIUserDetail)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(user)
                .append(APIUserDetail)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("user_detail", user)
                .append("APIUserDetail", APIUserDetail)
                .toString();
    }
    //endregion
}

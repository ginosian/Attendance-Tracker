package com.attendance_tracker.entity;

import com.attendance_tracker.misc.TokenType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "ApiAuthAccessToken")
@Table(name = "api_auth_access_token")
public class ApiAuthAccessToken extends AbstractEntity {

    // region PROPERTIES
    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @Column(name = "token_type")
    @Enumerated(EnumType.STRING)
    private TokenType tokenType;

    @Column(name = "expires")
    private LocalDateTime expires;

    @Column(name = "active", nullable = false)
    private Boolean active;

    @OneToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "api_auth_access_token_api_user_detail_fk"))
    private APIUserDetail apiUserDetail;
    // endregion

    //region GETTERS / SETTERS
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public TokenType getTokenType() {
        return tokenType;
    }
    public void setTokenType(TokenType tokenType) {
        this.tokenType = tokenType;
    }

    public LocalDateTime getExpires() {
        return expires;
    }
    public void setExpires(LocalDateTime expires) {
        this.expires = expires;
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }

    public com.attendance_tracker.entity.APIUserDetail getApiUserDetail() {
        return apiUserDetail;
    }

    public void setApiUserDetail(com.attendance_tracker.entity.APIUserDetail apiUserDetail) {
        this.apiUserDetail = apiUserDetail;
    }
    // endregion

    //region EQUALS / HASHCODE / TOSTRING
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        final ApiAuthAccessToken that = (ApiAuthAccessToken) o;
//        return new EqualsBuilder()
//                .appendSuper(super.equals(o))
//                .append(token, that.token)
//                .append(tokenType, that.tokenType)
//                .append(description, that.description)
//                .isEquals();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder(17, 37)
//                .appendSuper(super.hashCode())
//                .append(token)
//                .append(tokenType)
//                .append(description)
//                .toHashCode();
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this)
//                .appendSuper(super.toString())
//                .append("token", token)
//                .append("tokenType", tokenType)
//                .append("description", description)
//                .toString();
//    }
    //endregion
}

package com.attendance_tracker.entity;

import com.attendance_tracker.misc.TokenType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ApiAuthAccessToken that = (ApiAuthAccessToken) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(token, that.token)
                .append(tokenType, that.tokenType)
                .append(user, that.user)
                .append(description, that.description)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(token)
                .append(tokenType)
                .append(user)
                .append(description)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("token", token)
                .append("user_detail", user)
                .append("tokenType", tokenType)
                .append("description", description)
                .toString();
    }
    //endregion
}

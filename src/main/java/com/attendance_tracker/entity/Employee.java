package com.attendance_tracker.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Employee")
@Table(name = "employee")
public class Employee extends User {

    // region PROPERTIES
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Embedded
    private ContactDetails contactDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_division_id", nullable = false, foreignKey = @ForeignKey(name = "business_division_employee_fk"))
    private BusinessDivision businessDivision;

    @Column(name = "joining_date")
    private LocalDateTime joiningDate;

    @Column(name = "leaving_date")
    private LocalDateTime leavingDate;
    // endregion

    //region GETTERS / SETTERS
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BusinessDivision getBusinessDivision() {
        return businessDivision;
    }

    public void setBusinessDivision(BusinessDivision businessDivision) {
        this.businessDivision = businessDivision;
    }

    public LocalDateTime getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDateTime joiningDate) {
        this.joiningDate = joiningDate;
    }

    public LocalDateTime getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(LocalDateTime leavingDate) {
        this.leavingDate = leavingDate;
    }
    //endregion

    //region EQUALS / HASHCODE / TOSTRING
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (!(o instanceof Employee)) return false;

        final Employee that = (Employee) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("joiningDate", joiningDate)
                .append("leavingDate", leavingDate)
                .toString();
    }
    //endregion
}

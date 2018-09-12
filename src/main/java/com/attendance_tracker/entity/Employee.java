package com.attendance_tracker.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
public class Employee extends User{

    @OneToOne
    private Company company;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone", unique = true)
    private String phone;

    @Column(name = "joining_date")
    private LocalDateTime joiningDate;

    @Column(name = "leaving_date")
    private LocalDateTime leavingDate;

    //region GETTERS / SETTERS
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    //region equals/hashcode/toString
    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (!(o instanceof Employee)) return false;

        final Employee that = (Employee) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(email, that.email)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(email)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("email", email)
                .append("phone", phone)
                .append("joiningDate", joiningDate)
                .append("leavingDate", leavingDate)
                .toString();
    }
    //endregion
    //endregion
}

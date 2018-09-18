package com.attendance_tracker.entity;

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
//        final Employee that = (Employee) o;
//        return new EqualsBuilder()
//                .appendSuper(super.equals(o))
//                .append(firstName, that.firstName)
//                .append(lastName, that.lastName)
//                .append(businessDivision, that.businessDivision)
//                .append(joiningDate, that.joiningDate)
//                .append(leavingDate, that.leavingDate)
//                .isEquals();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder(17, 37)
//                .appendSuper(super.hashCode())
//                .append(firstName)
//                .append(lastName)
//                .append(businessDivision)
//                .append(joiningDate)
//                .append(leavingDate)
//                .toHashCode();
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this)
//                .appendSuper(super.toString())
//                .append("firstName", firstName)
//                .append("lastName", lastName)
//                .append("businessDivision", businessDivision)
//                .append("joiningDate", joiningDate)
//                .append("leavingDate", leavingDate)
//                .toString();
//    }
    //endregion
}

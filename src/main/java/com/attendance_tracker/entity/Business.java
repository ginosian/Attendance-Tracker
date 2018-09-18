package com.attendance_tracker.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Business")
@Table(name = "business")
public class Business extends User {

    // region PROPERTIES
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    // endregion

    //region GETTERS / SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
//        final Business that = (Business) o;
//        return new EqualsBuilder()
//                .appendSuper(super.equals(o))
//                .append(name, that.name)
//                .isEquals();
//    }
//
//    @Override
//    public int hashCode() {
//        return new HashCodeBuilder(17, 37)
//                .appendSuper(super.hashCode())
//                .append(name)
//                .toHashCode();
//    }
//
//    @Override
//    public String toString() {
//        return new ToStringBuilder(this)
//                .appendSuper(super.toString())
//                .append("name", name)
//                .toString();
//    }
    //endregion
}

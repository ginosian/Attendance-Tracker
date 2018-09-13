package com.attendance_tracker.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "business_division")
public class BusinessDivision extends AbstractEntity {

    @Embedded
    private ContactDetails contactDetails;

    @OneToOne
    private Policy default_policy;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "business_division_individual_policy",
            joinColumns = {@JoinColumn(name = "business_division_id")},
            inverseJoinColumns = {@JoinColumn(name = "individual_policy_id")})
    private Set<Policy> individualPolicies;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Employee> employees;


    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public Policy getDefault_policy() {
        return default_policy;
    }

    public void setDefault_policy(Policy default_policy) {
        this.default_policy = default_policy;
    }

    public Set<Policy> getIndividualPolicies() {
        return individualPolicies;
    }

    public void setIndividualPolicies(Set<Policy> individualPolicies) {
        this.individualPolicies = individualPolicies;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
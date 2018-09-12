package com.attendance_tracker.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "company_details")
public class CompanyDetails extends AbstractEntity{

    @OneToOne(optional = false)
    private Company company;

    @OneToOne
    private Policy policy;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<EmployeeIndividualPolicy> individualPolicies;

    // region GETTERS / SETTERS

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public Set<EmployeeIndividualPolicy> getIndividualPolicies() {
        return individualPolicies;
    }

    public void setIndividualPolicies(Set<EmployeeIndividualPolicy> individualPolicies) {
        this.individualPolicies = individualPolicies;
    }

    // endregion


}

package com.attendance_tracker.listener;

import com.attendance_tracker.entity.*;
import com.attendance_tracker.misc.AttendanceCalculationType;
import com.attendance_tracker.misc.TimeBufferType;
import com.attendance_tracker.misc.TimeOffMinDuration;
import com.google.common.collect.Sets;

import java.util.Set;

public class MockData {

    public static Business business(){
        final Business business = new Business();
        business.setName("Test Business");
        return business;
    }

    public static BusinessDetails businessDetails(final Business business, final BusinessDivision... businessDivision){
        final BusinessDetails businessDetails = new BusinessDetails();
        businessDetails.setBusiness(business);
        if (businessDivision != null) {
            businessDetails.setBusinessDivisions(Sets.newHashSet(businessDivision));
        }
        return businessDetails;
    }

    public static BusinessDivision businessDivision(final Set<Employee> employees, final Policy policy, final Set<Policy> individualPolicies, final ContactDetails contactDetails){
        final BusinessDivision businessDivision = new BusinessDivision();
        businessDivision.setDefaultPolicy(policy);
        businessDivision.setContactDetails(contactDetails);
        return businessDivision;
    }

    public static Employee employee(final BusinessDivision businessDivision, final ContactDetails contactDetails){
        final Employee employee = new Employee();
        employee.setFirstName("Test employee");
        employee.setBusinessDivision(businessDivision);
        employee.setContactDetails(contactDetails);
        return employee;
    }

    public static Owner owner(final ContactDetails contactDetails){
        final Owner owner = new Owner();
        owner.setContactDetails(contactDetails);
        return owner;
    }

    public static ContactDetails contactDetails(final Address address){
        final ContactDetails contactDetails = new ContactDetails();
        contactDetails.setEmail(contactDetails.hashCode() + "@" + contactDetails.hashCode() + ".com");
        contactDetails.setPhone(contactDetails.hashCode() + "123");
        contactDetails.setAddress(address);
        return contactDetails;
    }

    public static Address address(){
        final Address address = new Address();
        address.setCountry(address.hashCode() + "country");
        address.setPostcode(address.hashCode() + "postalCode");
        return address;
    }

    public static Policy policy(final BusinessDivision businessDivision, final AttendancePolicy attendancePolicy, final TimeOffPolicy timeOffPolicy, final VacationPolicy vacationPolicy){
        final Policy policy = new Policy();
        policy.setBusinessDivision(businessDivision);
        policy.setAttendancePolicy(attendancePolicy);
        policy.setTimeOffPolicy(timeOffPolicy);
        policy.setVacationPolicy(vacationPolicy);
        return policy;
    }

    public static AttendancePolicy attendancePolicy(final Set<Period> ins, final Set<Period> outs){
        final AttendancePolicy attendancePolicy = new AttendancePolicy();
        attendancePolicy.setAttendanceCalculationType(AttendanceCalculationType.DAILY);
        attendancePolicy.setWorkingDaysPerWeek(5);
        attendancePolicy.setWorkingHoursPerDay(8);
        attendancePolicy.setWorkingHoursPerWeek(40);
        attendancePolicy.setInPeriods(ins);
        attendancePolicy.setOutPeriods(outs);
        return attendancePolicy;
    }

    public static TimeOffPolicy timeOffPolicy(){
        final TimeOffPolicy timeOffPolicy = new TimeOffPolicy();
        timeOffPolicy.setRegisterAsVacationImmediate(false);
        timeOffPolicy.setTimeOffMinDuration(TimeOffMinDuration.HALF_DAY);
        return timeOffPolicy;
    }

    public static VacationPolicy vacationPolicy(){
        final VacationPolicy vacationPolicy = new VacationPolicy();
        vacationPolicy.setVacationPerDay(0.09);
        vacationPolicy.setVacationPerMonth(1.67);
        vacationPolicy.setVacationPerWeek(0.4);
        vacationPolicy.setVacationPerYear(22D);
        return vacationPolicy;
    }

    public static Period period(){
        final Time startTime = new Time();
        startTime.setHour(10);
        startTime.setMinute(0);
        final Time startTimeBuffer = new Time();
        startTimeBuffer.setHour(0);
        startTimeBuffer.setMinute(40);
        final TimeBufferType startTimeBufferType = TimeBufferType.LATER;

        final Time endTime = new Time();
        endTime.setHour(19);
        endTime.setMinute(0);
        final Time endTimeBuffer = new Time();
        endTimeBuffer.setHour(0);
        endTimeBuffer.setMinute(40);
        final TimeBufferType endTimeBufferType = TimeBufferType.EARLIER;

        final Period period = new Period();
        period.setEnd(endTime);
        period.setEndBuffer(endTimeBuffer);
        period.setEndBufferType(endTimeBufferType);
        period.setStart(startTime);
        period.setStartBuffer(startTimeBuffer);
        period.setStartBufferType(startTimeBufferType);
        return period;
    }
}

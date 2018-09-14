package com.attendance_tracker.listener;

import com.attendance_tracker.entity.*;
import com.attendance_tracker.repository.AbstractRepository;
import com.attendance_tracker.repository.BusinessDivisionRepository;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ApplicationEventListener {
    private final Logger logger = LoggerFactory.getLogger(ApplicationEventListener.class);

    @Autowired
    private AbstractRepository abstractRepository;

    @Autowired
    private BusinessDivisionRepository businessDivisionRepository;

    @Autowired
    Environment environment;

    @EventListener({ContextRefreshedEvent.class})
    public void onContextRefreshedEvent() {
        final String[] profiles  = environment.getActiveProfiles();
        if(profiles.length > 0){
            return;
        }
        logger.info("Saving Roles ...");
        final List<Role> roles = abstractRepository.saveAll(StaticData.createRoles());
        logger.debug("Done saving Roles.");

        logger.info("Saving Permissions ...");
        final List<Permission> permissions = abstractRepository.saveAll(StaticData.createPermissions().stream().peek(permission -> permission.setRole(roles.get(0))).collect(Collectors.toSet()));
        logger.debug("Done saving Permissions.");

        logger.info("Saving Business ...");
        final Business business = abstractRepository.save(MockData.business());
        logger.debug("Done saving Business.");

        logger.info("Saving Business Details ...");
        final BusinessDetails businessDetails = abstractRepository.save(MockData.businessDetails(business, null));
        logger.debug("Done saving Business Details.");

        logger.info("Saving Business Division...");
        final BusinessDivision businessDivision = abstractRepository.save(MockData.businessDivision(businessDetails, null, null, null, MockData.contactDetails(MockData.address())));
        logger.debug("Done saving Business Division.");

        logger.info("Saving Employee ...");
        final Employee employee = abstractRepository.save(MockData.employee(businessDivision, MockData.contactDetails(MockData.address())));
        logger.debug("Done saving Employee.");

        logger.info("Saving Owner ...");
        final Owner owner = abstractRepository.save(MockData.owner(MockData.contactDetails(MockData.address())));
        logger.debug("Done Owner.");

        logger.info("Saving Attendance Policy ...");
        AttendancePolicy attendancePolicy = abstractRepository.save(MockData.attendancePolicy());
        logger.debug("Done Attendance Policy.");

        logger.info("Saving Period Details ...");
        final List<PeriodDetail> periodDetails = abstractRepository.saveAll(
                MockData.periodsSet().stream().peek(periodDetail -> periodDetail.setAttendancePolicy(attendancePolicy)).collect(Collectors.toSet())
        );
        logger.debug("Done Period Details.");

        logger.info("Saving Periods ...");
        periodDetails.forEach(periodDetail -> {
            final Period period = MockData.period();
            period.setPeriodDetail(periodDetail);
            abstractRepository.save(period);
        });
        logger.debug("Done Periods.");


        logger.info("Saving Time Off Policy ...");
        final TimeOffPolicy timeOffPolicy = abstractRepository.save(MockData.timeOffPolicy());
        logger.debug("Done Time Off Policy.");

        logger.info("Saving Vacation Policy ...");
        final VacationPolicy vacationPolicy = abstractRepository.save(MockData.vacationPolicy());
        logger.debug("Done Vacation Policy.");

        logger.info("Saving Business Division with policy ...");
        Policy policy = MockData.policy(businessDivision, attendancePolicy, timeOffPolicy, vacationPolicy);
        businessDivision.setDefaultPolicy(policy);
        abstractRepository.save(businessDivision);
        logger.debug("Done Business Division with policy.");

        logger.info("Saving User Details ...");
        final UserDetails employeeDetails = abstractRepository.save(MockData.userDetails(Sets.newHashSet(roles), employee, owner));
        final UserDetails ownerDetails = abstractRepository.save(MockData.userDetails(Sets.newHashSet(roles), owner, owner));
        logger.debug("Done User Details.");

        logger.info("Saving Authority ...");
        Authority authorityEmployee = MockData.authority(employee, employeeDetails);
        authorityEmployee = abstractRepository.save(authorityEmployee);
        Authority authorityOwner = MockData.authority(owner, ownerDetails);
        authorityOwner = abstractRepository.save(authorityOwner);
        logger.debug("Done Authority.");

        logger.info("Saving Auth Access Token ...");
        final AuthAccessToken authAccessTokenEmployee = abstractRepository.save(MockData.authAccessToken(authorityEmployee));
        final AuthAccessToken authAccessTokenOwner = abstractRepository.save(MockData.authAccessToken(authorityOwner));
        logger.debug("Done Auth Access Token.");
    }
}

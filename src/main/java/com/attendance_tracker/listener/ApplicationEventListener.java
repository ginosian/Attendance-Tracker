package com.attendance_tracker.listener;

import com.attendance_tracker.repository.AbstractRepository;
import com.attendance_tracker.repository.BusinessDivisionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

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
//        final String[] profiles  = environment.getActiveProfiles();
//        if(profiles.length > 0){
//            return;
//        }
//        logger.info("Saving Permissions ...");
//        final List<Permission> permissions = abstractRepository.saveAll(StaticData.createPermissions());
//        logger.debug("Done saving Permissions.");
//
//        logger.info("Saving Roles ...");
//        final List<Role> roles = abstractRepository.saveAll(
//                StaticData.createRoles()
//                        .stream()
//                        .peek(role -> role.setPermissions(Sets.newHashSet(permissions)))
//                        .collect(Collectors.toSet()));
//        logger.debug("Done saving Roles.");
//
//        logger.info("Saving Business ...");
//        final Business business = abstractRepository.save(MockData.business());
//        logger.debug("Done saving Business.");
//
//        logger.info("Saving Business Division...");
//        final BusinessDivision businessDivision = abstractRepository.save(MockData.businessDivision(null, null, null, null));
//        logger.debug("Done saving Business Division.");
//
//        logger.info("Saving Business Details ...");
//        final BusinessDetails businessDetails = abstractRepository.save(MockData.businessDetails(business, businessDivision));
//        logger.debug("Done saving Business Details.");
//
//        logger.info("Saving Employee ...");
//        final Employee employee = abstractRepository.save(MockData.employee(businessDivision, MockData.contactDetails(MockData.address())));
//        logger.debug("Done saving Employee.");
//
//        logger.info("Saving Owner ...");
//        final Owner owner = abstractRepository.save(MockData.owner(MockData.contactDetails(MockData.address())));
//        logger.debug("Done Owner.");
//
//        logger.info("Saving Business Division with policy ...");
//        final AttendancePolicy attendancePolicy = MockData.attendancePolicy(Sets.newHashSet(MockData.period()), Sets.newHashSet(MockData.period()));
//        final TimeOffPolicy timeOffPolicy = MockData.timeOffPolicy();
//        final VacationPolicy vacationPolicy = MockData.vacationPolicy();
//        final Policy policy = abstractRepository.save(MockData.policy(businessDivision, attendancePolicy, timeOffPolicy, vacationPolicy));
//        logger.debug("Done Business Division with policy.");
    }
}

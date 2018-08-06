package com.attendance_tracker.listener;


import com.attendance_tracker.entity.Company;
import com.attendance_tracker.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationEventListener {

    @Autowired
    private CompanyRepository companyRepository;

    @EventListener({ContextRefreshedEvent.class})
    public void onContextRefreshedEvent() {
        Company company = new Company();
        company.setEmail("a@a.com");
        company.setName("name");
        company = companyRepository.save(company);
        companyRepository.findOne(company.getId());
    }
}

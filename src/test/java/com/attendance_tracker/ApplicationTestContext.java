package com.attendance_tracker;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:application-test.properties")
//@ImportResource("classpath:hr/app-test-context.xml")
public class ApplicationTestContext {
}

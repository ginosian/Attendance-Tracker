package com.attendance_tracker;


import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles(value = "test")
@ContextConfiguration(classes = ApplicationTestContext.class)
public class AbstractTest {
}

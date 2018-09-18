package com.attendance_tracker;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = "com.attendance_tracker", exclude = {JacksonAutoConfiguration.class})
@ImportResource("hr/app-context.xml")
public class Application {

    protected Application() {
        super();
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).bannerMode(Banner.Mode.OFF).run(args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

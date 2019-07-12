package com.security.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class SecurityWebApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SecurityWebApplication.class, args);
        System.out.println("spring security 加载bean"+context.getBean(SecurityAutoConfiguration.class));
    }


}

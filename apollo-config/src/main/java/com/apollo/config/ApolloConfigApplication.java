package com.apollo.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sansan.si
 */
@SpringBootApplication
@EnableApolloConfig
public class ApolloConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApolloConfigApplication.class, args);
    }

}

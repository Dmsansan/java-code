package com.sansan.springboot.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.sansan.springboot.api.mapper"})
public class ApiManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiManagerApplication.class, args);
    }

}
